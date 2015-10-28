package com.imxiaomai.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.toolkit.DateUtil;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.entity.User;
import com.imxiaomai.entity.UserStat;
//import com.imxiaomai.log.AutoLogs;
import com.imxiaomai.web.base.BaseController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class WxInviteHitAction extends BaseController {/*
	
	@Resource WxInviteHit
	
	
    private static final Logger log = LoggerFactory.getLogger(WxInviteHitAction.class);

    @RequestMapping("/wx/insertInviteHit")
    @ResponseBody
    public Object insertInviteHit( HttpServletRequest request) throws  Exception {
//    	Insert into wxInitedHit (inviteCode,phone,`date`) VALUES (?,?,?)
    	
    	String json = getDataFromRequest(request);
		JsonNode jsonObject = JsonUtil.parse(json);
		final String inviteCode = jsonObject.findValue("inviteCode") != null ? jsonObject.findValue("inviteCode").asText() : "";
		final String phone = jsonObject.findValue("phone")!=null ? jsonObject.findValue("phone").asText() : "";
		
    	
        long start = System.currentTimeMillis();
        if (!isIntranetRequest(request)) {
            AutoLogs.sellerCaseIPErr.end(start);
            return buildErrJson("IP不在白名单！");
        }

        List<WxUnBindUser> todayBindUsers = WxUnBindUser.getTodayBindUsers();
        if (todayBindUsers.isEmpty()){
            AutoLogs.updateInviteHit.end(start);
            return buildJson(0, "成功");
        }

        for (WxUnBindUser bindUser : todayBindUsers) {
            try {
                User user = User.getById(bindUser.userId);
                if (user == null){
                    continue;
                }
                if (user.isHit()){
                    WxInviteHit.add(bindUser.icode, user.mobilePhone, DateUtil.getDay(bindUser.updateTime));
                    UserStat.addInviteHitCount(bindUser.icode);
                }
            } catch (Exception e){
                log.error("wx.updateInviteHit, WxUnBindUser={} hitting error", bindUser.userId);
            }
        }

        AutoLogs.updateInviteHit.end(start);
        return buildJson(0, "成功");
    }
    
*/}
