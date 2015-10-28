package com.imxiaomai.web;

import static com.imxiaomai.base._.isNotEmpty;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.service.FeedBackService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class FeedBackController extends BaseController{
	
	@Resource 
	FeedBackService feedBackService;

	@RequestMapping("/user/feedback")
	@ResponseBody
	public Object feedBack(HttpServletRequest request) throws IOException, SQLException {
		final String rawData = getDataFromRequest(request);
		if( isNotEmpty(rawData) ){
			JsonNode jsonNode = JsonUtil.parse(rawData);
			final long userId = jsonNode.findValue("userId").asLong();
			final String userInfo = jsonNode.findValue("userInfo").asText();
			final String feedText = jsonNode.findValue("feedText").asText();
			int index = feedBackService.feedBack(userId, userInfo, feedText);
			if(index == 1){
				return buildJson(0,"感谢反馈，反馈成功~");
			}
			return buildJson(0,"感谢反馈，反馈成功~");
		}
		return buildJson(-1,"缺少参数");
	}

}