package com.imxiaomai.web;

import static com.imxiaomai.base._.asList;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imxiaomai.base.util.JsonUtil;
//import com.imxiaomai.entity.StoreExpress;
//import com.imxiaomai.entity.StoreInfo;
import com.imxiaomai.persistence.domain.Store;
import com.imxiaomai.persistence.domain.StoreExpress;
import com.imxiaomai.service.StoreExpressService;
//import com.imxiaomai.entity.StoreInfoExtend;
import com.imxiaomai.service.StoreService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class StoreAction extends BaseController {

    @Resource
    StoreService storeService;
    @Resource
    StoreExpressService storeExpressService;

    private static Logger log = Logger.getLogger(StoreAction.class);

    @RequestMapping("/store/get")
    @ResponseBody
    public Object getStore(HttpServletRequest request) throws IOException, SQLException {
        String json = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(json);
        long id = jsonNode.findValue("id") != null ? jsonNode.findValue("id").asLong() : 0;
        return buildJsonAddFoo(0, "", storeService.getStore(id));
    }

    @RequestMapping("/storeExtend/get")
    @ResponseBody
    public Object getStoreExtend(HttpServletRequest request) throws IOException, SQLException {
        String json = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(json);
        long id = jsonNode.findValue("id") != null ? jsonNode.findValue("id").asLong() : 0;
        List<Map<String, Object>> reslist = new ArrayList<Map<String, Object>>();

        List<Store> storelist = storeService.getStore(id);
        int len = storelist.size();
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                reslist.add(storeService.toMap(storelist.get(i)));
            }
        }
        return buildJsonAddFoo(0, "", reslist);
//		return buildJsonAddFoo(0,"",storeService.getStoreExtend(id));
    }

    @RequestMapping("/store/getByCollegeId")
    @ResponseBody
    public Object getStoreByCollegeId(HttpServletRequest request) throws IOException, SQLException {
        String json = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(json);
        int id = jsonNode.findValue("collegeId") != null ? jsonNode.findValue("collegeId").asInt() : 0;
        int isdel = jsonNode.findValue("isdel") != null ? jsonNode.findValue("isdel").asInt() : 0;
        if (id <= 0) {
            return buildErrJson(-1, "参数缺失");
        }
        Store bean = new Store();
        bean.setCollegeId(id);
        bean.setIsdel(isdel);
//		StoreInfo info = StoreInfo.getByCollegeId(id);
        Store info = storeService.getByCollegeId(bean);
        if (info == null) {
            info = new Store();
        }
        return buildJson(0, "", info);
//		return buildRetJson(0, "", info);
    }

    @RequestMapping("/store/update")
    @ResponseBody
    public Object updateStore(HttpServletRequest request) throws IOException, SQLException {
        String json = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(json);
        long id = jsonNode.findValue("id").asLong();
        String short_address = jsonNode.findValue("short_address").asText();
        String telphone = jsonNode.findValue("telphone").asText();
        String lastBussTime = jsonNode.findValue("latest_business_time").asText();

//		int suc = StoreInfo.update(id,short_address,telphone,lastBussTime);
        int suc = storeService.update(id, short_address, telphone, lastBussTime);
        if (suc > 0)
            return buildJson(0, "修改成功");
        return buildJson(0, "修改失败");
    }

    @RequestMapping(value = "/store/updateById", method = {RequestMethod.POST})
    @ResponseBody
    public Object updateStoreById(HttpServletRequest request) throws IOException, SQLException {
        String json = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(json);
        long id = jsonNode.findValue("id").asLong();
        String short_address = jsonNode.findValue("short_address").asText();
        String take_express_phone = jsonNode.findValue("take_express_phone").asText();
        String latest_business_time = jsonNode.findValue("latest_business_time").asText();

//		int suc = StoreInfo.update(id, short_address, take_express_phone, latest_business_time);
        int suc = storeService.update(id, short_address, take_express_phone, latest_business_time);
        if (suc > 0)
            return buildJson(0, "修改成功");
        return buildErrJson("修改失败");
    }

    @RequestMapping(value = "/store/updateSelective", method = {RequestMethod.POST})
    @ResponseBody
    public Object updateSelective(HttpServletRequest request) throws Exception {
        String json = getDataFromRequest(request);
//		StoreInfoExtend storeInfoExtend = new ObjectMapper().readValue(json, StoreInfoExtend.class);
        Store store = new ObjectMapper().readValue(json, Store.class);
        if (store == null) {
            return buildJson(-1, "参数格式错误");
        }
        storeService.updateSelective(store);
//		storeInfoExtend.updateSelective();
        return buildJson(0, "修改成功");
    }

    @RequestMapping("/store/express")
    @ResponseBody
    public Object getStoreExpress(HttpServletRequest request) throws IOException, SQLException {
        String json = getDataFromRequest(request);
        JsonNode jsonNode = JsonUtil.parse(json);
        long storeId = jsonNode.findValue("storeId") != null ? jsonNode.findValue("storeId").asLong() : 0;

        List<StoreExpress> storeExpress;
        if (storeId != 0) {
            storeExpress = asList(storeExpressService.getByStoreId(storeId));
//			storeExpress = asList(StoreExpress.getByStoreId(storeId));
        } else {
            storeExpress = storeExpressService.getAll();
//			storeExpress = StoreExpress.getAll();
        }

        return buildJsonAddFoo(0, "", storeExpress);

    }

    @RequestMapping("/store/getByStatusExpr")
    @ResponseBody
    public Object getByParam(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(required = false, defaultValue = "0") String statusStr,
                             @RequestParam(required = false, defaultValue = "") String dispatchIdsStr,
                             @RequestParam(required = false, defaultValue = "") String areaIdStr,
                             @RequestParam(required = false, defaultValue = "") String cityIdStr
                            ) throws IOException, SQLException {
        List<Store> ret = new ArrayList<Store>();
        try{
            Integer status = Integer.valueOf(statusStr);
            List<String> dispathIdsList = new ArrayList<String>();
            if(StringUtils.isNotEmpty(dispatchIdsStr)){
               dispathIdsList = Arrays.asList(dispatchIdsStr.split(","));
            }
            ret = storeService.getByStatusExpress(status, dispathIdsList,areaIdStr, cityIdStr);
        }catch (Exception e){
            log.error("get store list failed", e);
            buildJson(500, "根据参数获取门店信息异常", ret);
        }
        return buildJson(0, "", ret);
    }
}
