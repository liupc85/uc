package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.toolkit.AutoLog;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.UserStat;
import com.imxiaomai.service.ScorelistService;
import com.imxiaomai.service.UserStatService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class P2pTaskAction extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(P2pTaskAction.class);
    private static final AutoLog P2pTaskLog = AutoLog.of("P2pTaskAction.log");
    
    @Resource
    private UserStatService userStatService ;
    
    @Resource
    private ScorelistService scorelistService;
    
    @RequestMapping("/app/judgeTask")
    @ResponseBody
    public Object judgeTask(HttpServletRequest request) throws IOException, SQLException {
    	//1、获取userstat
    	//2、userstat 加减gold
    	//3、插入数据到score_list

    	String data = getDataFromRequest(request);	
    	logger.info("/app/judgeTask \t", data);
		JsonNode jsonNode = JsonUtil.parse(data);
		
		final String userId = jsonNode.findValue("userId") == null ? "" : jsonNode.findValue("userId").asText();
		final String score = jsonNode.findValue("score") == null ? "" : jsonNode.findValue("score").asText();
		final String type = jsonNode.findValue("type") == null ? "" : jsonNode.findValue("type").asText();
		final String tips = jsonNode.findValue("tips") == null ? "" : jsonNode.findValue("tips").asText();
		final String identify = jsonNode.findValue("identify") == null ? "" : jsonNode.findValue("identify").asText();
		final String outId = jsonNode.findValue("outId") == null ? "" : jsonNode.findValue("outId").asText();
		
		logger.info("/app/judgeTask userId：{} score：{} type：{} tips：{} identify：{} outId：{}", userId,score,type,tips,identify,outId);
		
		UserStat stat=null;
		System.out.println("userId "+userId);
		if(!StringUtils.isEmpty(userId)&&!userId.equals("0")){
			stat=userStatService.getByUserId(Long.parseLong(userId));
		}
		if(stat==null){
			return buildJson(-1, "根据userId未查询到UserStat信息");
		}
		int exsit_gold=stat.getGold();
		logger.info("exsit_gold :{}",exsit_gold);
		int update_res=userStatService.updateByPair("gold", new Integer(exsit_gold+Integer.parseInt(score)), Integer.parseInt(userId));
		logger.info("update_res :{}",update_res);
		if(update_res>0){
			int insert_res=scorelistService.insert(Integer.parseInt(userId), Long.parseLong(score), Long.parseLong(type), Long.parseLong(identify), Long.parseLong(outId), tips);
			logger.info("insert_res :{}",insert_res);
			if(insert_res>0){
				return buildJson(0, "操作成功");
			}else{
				return buildJson(-1, "操作失败");
			}
		}else{
			return buildJson(-1, "update gold信息出错");
		}
    }
    
}
