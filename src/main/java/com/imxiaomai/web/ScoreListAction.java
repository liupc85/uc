package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base._;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.service.ScorelistService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class ScoreListAction extends BaseController{

	@Resource
	ScorelistService scorelistService;
	
	
	@RequestMapping("/scoreList/insertScoreList")
	@ResponseBody
	public Object insertScoreList(HttpServletRequest request) throws IOException, SQLException {
		String data = getDataFromRequest(request);
		JsonNode jsonNode = JsonUtil.parse(data);

		final long userId = jsonNode.findValue("userId").asLong();
		final String score = jsonNode.findValue("score").asText();
		final String type = jsonNode.findValue("type").asText();
		final String tips = jsonNode.findValue("tips").asText();
		final int identify = jsonNode.findValue("identify").asInt();
		final int outId = jsonNode.findValue("outId").asInt();

//		Insert into score_list (`userId`,`score`,`type`,`tips`,`time`,`identify`,`outId`) 
		int res=scorelistService.insert((int)userId, _.toLong(score), _.toLong(type), new Long(identify), new Long(outId),tips);

		if(res==0){
			return buildJson(-1,"插入scoreList错误");
		}else{
			return buildJson(0,"","插入scoreList正确");
		}
	}
}
