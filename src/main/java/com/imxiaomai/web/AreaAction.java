package com.imxiaomai.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.imxiaomai.base.toolkit.AutoLog;
import com.imxiaomai.service.AreaService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class AreaAction extends BaseController {
    static final Logger logger = LoggerFactory.getLogger(AreaAction.class);
    private static final AutoLog areaLog = AutoLog.of("areaAction.log");
    
    @Resource
    private AreaService areaService ;
    
    @RequestMapping("/area/getList")
    @ResponseBody
    public Object getAreaList(HttpServletRequest request) throws IOException, SQLException {
	   long start = System.currentTimeMillis();
       JsonObject dataObj = new JsonObject();
//       JsonArray json = areaService.getAreaList();
//       if(json == null){
//    	  json = new JsonArray();
//       }
//       dataObj.add("areaList", json);
       areaLog.end(start);
//       return buildRetJson(0, "", dataObj);
       Gson gson=new Gson ();
       gson.toJson(dataObj);
       
       Map<String,Object> map=new HashMap<String,Object> ();
       map.put("areaList", areaService.getAreaList());
       
       return buildJson(0, "", map);
    }
}
