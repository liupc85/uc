package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.persistence.domain.Store;
import com.imxiaomai.entity.User;
import com.imxiaomai.persistence.domain.College;
import com.imxiaomai.service.CollegeService;
import com.imxiaomai.service.StoreService;
import com.imxiaomai.service.UserService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class CollegeAction extends BaseController{
	
	@Resource
	private CollegeService collegeService;
	@Resource
	private UserService userService ;
	
	@Resource
	private StoreService storeService;
	
	@RequestMapping("/college/get")
	@ResponseBody
	public Object getCollege(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonObject = JsonUtil.parse(json);
		final long id = jsonObject.findValue("id") != null ? jsonObject.findValue("id").asLong() : 0;
		final long provinceId = jsonObject.findValue("province_id")!=null ? jsonObject.findValue("province_id").asLong() : 0;
		List<College> collegeInfos = collegeService.getCollege(id, provinceId);
		return buildJsonAddFoo(0, "", collegeInfos);
//		return buildJson(0,"",collegeInfos);
	}
	
	@RequestMapping("/college/updateCollegeId")
	@ResponseBody
	public Object updateCollegeId(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonObject = JsonUtil.parse(json);
		final long userId = jsonObject.findValue("userId") != null ? jsonObject.findValue("userId").asLong() : 0;
		final long collegeId = jsonObject.findValue("collegeId")!=null ? jsonObject.findValue("collegeId").asLong() : 0;
		int res=userService.updateByPair("collegeId", collegeId, "id", userId);
		if(res>0){
			return buildJson(0, "更新成功"); 
		}else{
			return buildJson(-1, "更新失败"); 
		}
	}
	

	@RequestMapping("/college/updateCollegeIdByStoreId")
	@ResponseBody
	public Object updateCollegeIdByStoreId(HttpServletRequest request) throws IOException, SQLException {
		String json = getDataFromRequest(request);
		JsonNode jsonObject = JsonUtil.parse(json);
		final long userId = jsonObject.findValue("userId") != null ? jsonObject.findValue("userId").asLong() : 0;
		final long storeId = jsonObject.findValue("storeId")!=null ? jsonObject.findValue("storeId").asLong() : 0;
		if(userId==0||storeId==0){
			return buildJson(-1, "参数错误"); 
		}
		
	    Store store=storeService.getById(storeId);
	    if(store!=null){
		    int collegeId=store.getCollegeId();
    		int res=userService.updateByPair("collegeId", collegeId, "id", userId);
    		if(res>0){
    			return buildJson(0, "更新成功"); 
    		}else{
    			return buildJson(-1, "更新失败"); 
    		}
	    }else{
	    	return buildJson(-1, "根据storeId未查询到数据"); 
	    }

	}
	
}
