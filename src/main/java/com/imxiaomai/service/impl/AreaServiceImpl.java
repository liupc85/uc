package com.imxiaomai.service.impl;

import java.util.*;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.imxiaomai.dao.CollegeDao;
import com.imxiaomai.fw.client.codis.CommonClient;
import com.imxiaomai.fw.client.codis.pool.PoolType;
import com.imxiaomai.manager.CollegeManager;
import com.imxiaomai.manager.ProvinceManager;
import com.imxiaomai.persistence.domain.Province;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.service.AreaService;
import com.imxiaomai.util.ConfigUtil;
import com.imxiaomai.util.RedisUtil;

public class AreaServiceImpl implements AreaService {
	
	@Resource
	private CollegeManager collegeManager;
	
	@Resource
	private ProvinceManager provinceManager;
	
	
	
	@Resource
	private CollegeDao collegeDao;
	
	static final Logger logger = LoggerFactory.getLogger(AreaService.class);
//	private final static int expir = ConfigUtil.getIntValue("codis.expir");
//	private static CommonClient commonClient = new CommonClient(PoolType.roundRobin,ConfigUtil.getIntValue("codis.trynum"));
//	private final static String codisPre = ConfigUtil.getStringValue("codis.dataPre")+"_area";
	@Override
	public List<Map<Object,Object>> getAreaList() {
		
		Map<Long, Map<Long, String>> provinces = collegeManager.getAllWithColleges();
        if (provinces.isEmpty()){
            logger.warn("area.getList.case.provincesEmpty");
            return null;
        }
        
        List<Map<Object,Object>> reslist=new ArrayList<Map<Object,Object>> ();
//        String areaList = commonClient.get(codisPre);
//        areaList=null;
        
        for (long provinceId : provinces.keySet()) {
//        	System.out.println("provinceId "+provinceId );
            List<Map<Object,Object>> list=new ArrayList<Map<Object,Object>> ();
            
            Map<Long, String> kv = provinces.get(provinceId);
//            System.out.println("kv.keySet() "+kv.keySet().toString());
            for (long collegeId : kv.keySet()) {
            	Map<Object,Object> tmp=new HashMap<Object,Object>();
            	tmp.put("collegeId", collegeId);
                tmp.put("collegeName", kv.get(collegeId));
                list.add(tmp);
            }
            Province province = provinceManager.getById(provinceId);
            if (province == null){
                logger.warn("area.getList.case.areaError, area:{} is not exist", provinceId);
                continue;
            }
            Map<Object,Object> map=new HashMap<Object,Object> ();
            map.put("total", kv.size());
            map.put("areaId", provinceId);
            map.put("areaName", province.getName());
            map.put("collegeList", list);
            reslist.add(map);
        }
        
//        commonClient.set(codisPre, reslist.toString());
		return reslist;
	}
	
//	@Override
/*	public JsonArray getAreaListOld() {
		Map<Long, Map<Long, String>> provinces = collegeManager.getAllWithColleges();
        if (provinces.isEmpty()){
            logger.warn("area.getList.case.provincesEmpty");
            return null;
        }
        
        //google gson --> Gson、JsonParser、JsonObject、JsonArray
        String codisareaArray = commonClient.get(codisPre);
        if(codisareaArray!=null){
        	JsonParser parser = new JsonParser();
        	JsonElement el = parser.parse(codisareaArray);
        	JsonArray jsonArray = el.getAsJsonArray();
        	return jsonArray;
        }
        
        JsonArray areaArray = new JsonArray();
        for (long provinceId : provinces.keySet()) {
            JsonArray collegeArray = new JsonArray();
            JsonObject areaObj = new JsonObject();
            Map<Long, String> kv = provinces.get(provinceId);
            for (long collegeId : kv.keySet()) {
                JsonObject obj = new JsonObject();
                obj.addProperty("collegeId", collegeId);
                obj.addProperty("collegeName", kv.get(collegeId));
                collegeArray.add(obj);
            }
            Province province = provinceManager.getById(provinceId);
            if (province == null){
                logger.warn("area.getList.case.areaError, area:{} is not exist", provinceId);
                continue;
            }
            areaObj.addProperty("total", kv.size());
            areaObj.addProperty("areaId", provinceId);
            areaObj.addProperty("areaName", province.getName());
            areaObj.add("collegeList", collegeArray);
            areaArray.add(areaObj);
        }
        
        commonClient.set(codisPre, areaArray.toString());
		return areaArray;
	}*/
	
	
	
}
