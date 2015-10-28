package com.imxiaomai.service.impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.JsonObject;
import com.imxiaomai.manager.AreaManager;
import com.imxiaomai.manager.CityManager;
import com.imxiaomai.manager.ExpressPriceManager;
import com.imxiaomai.manager.ExpressPriceSfManager;
import com.imxiaomai.persistence.domain.Area;
import com.imxiaomai.persistence.domain.City;
import com.imxiaomai.persistence.domain.ExpressPrice;
import com.imxiaomai.persistence.domain.ExpressPriceSf;
import com.imxiaomai.service.ExpressPriceService;

public class ExpressPriceServiceImpl implements ExpressPriceService {
	
	
	@Resource 
	AreaManager areaManager;
	
	@Resource 
	CityManager cityManager;
	
	@Resource
	ExpressPriceManager  expressPriceManager;
	
	@Resource
	ExpressPriceSfManager expressPriceSfManager;
	

	@Override
	public List<HashMap<String, Class>> getListWithTotalPrice(long sourceAreaId, long targetAreaId,double weight) {
		//根据区域查省
		Area sourceAreaInfo = areaManager.getById(sourceAreaId);
		City sourceCityInfo = cityManager.getById(sourceAreaInfo.getCityId().longValue());
		
		Area targetAreaInfo = areaManager.getById(targetAreaId);
		City targetCityInfo = cityManager.getById(targetAreaInfo.getCityId().longValue());
		
		List<ExpressPrice> expressPriceList = expressPriceManager.getExpressListByProvince2Province(sourceCityInfo.getProvinceId().longValue(), targetCityInfo.getProvinceId().longValue());
		
		List<HashMap<String, Class>> resultList = new ArrayList<HashMap<String, Class>>();
		
		if (expressPriceList == null || expressPriceList.size() == 0) {
            //空，没有数据
            return resultList;
        }
		
		ObjectMapper om = new ObjectMapper();
        for (ExpressPrice obj : expressPriceList) {
            
            double baseWeight = 1.0;
            double tmpWeight = weight - baseWeight;
            String price = "";
            if (weight <= baseWeight) {
            	price = obj.getPrice1().toString();
            }else {
            	price = String.valueOf((obj.getPrice1() + tmpWeight*obj.getPrice2()));
            }
            try {
				resultList.add(om.readValue(price, HashMap.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
		return resultList;
	}


	@Override
	public List<HashMap<ExpressPrice, Class>> getList(long sourceProvinceId,long targetProvinceId) {
		 List<ExpressPrice> expressPriceList = expressPriceManager.getExpressListByProvince2Province(sourceProvinceId, targetProvinceId);
		 List<HashMap<ExpressPrice, Class>> resultList = new ArrayList<HashMap<ExpressPrice, Class>>();
         if (expressPriceList == null || expressPriceList.size() == 0) {
            //空，没有数据
            return resultList;
         }
         
         HashMap<ExpressPrice, Class> om = new HashMap<ExpressPrice, Class>();
         for (ExpressPrice obj : expressPriceList) {
        	 om.put(obj, HashMap.class);
         }
         resultList.add(om);
		 return resultList;
	}


	@Override
	public List<HashMap> getListByStoreAndTargetCity(long storeId,long targetCityId) {
		List<ExpressPrice> expressPriceList = expressPriceManager.getExpressPriceListByStoreIdAndTargetCityId(storeId, targetCityId);
		if (expressPriceList == null || expressPriceList.size() == 0) {
	            //到市一级没有数据，取到省一级的。
	            City cityInfo = cityManager.getById(targetCityId);
	            expressPriceList = expressPriceManager.getExpressPriceListByStoreIdAndTargetProvinceId(storeId, cityInfo.getProvinceId().longValue());
	    }
		List<HashMap> resultList = new ArrayList<HashMap>();
		if (expressPriceList == null || expressPriceList.size() == 0) {
	            //空，没有数据
	            return resultList;
	    }
		ObjectMapper om = new ObjectMapper();
	    for (ExpressPrice obj : expressPriceList) {
	    	JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", obj.getId());
			jsonObject.addProperty("expressId", obj.getExpressid());
			jsonObject.addProperty("sourceProvinceId", obj.getSourceprovinceid());
			jsonObject.addProperty("sourceCityId", obj.getSourcecityid());
			jsonObject.addProperty("sourceAreaId", obj.getSourceareaid());
			jsonObject.addProperty("sourceStoreId", obj.getSourcestoreid());
			jsonObject.addProperty("targetProvinceId", obj.getTargetprovinceid());
			jsonObject.addProperty("targetCityId", obj.getTargetcityid());
			jsonObject.addProperty("targetAreaId", obj.getTargetareaid());
			jsonObject.addProperty("targetStoreId", obj.getTargetstoreid());
			jsonObject.addProperty("price1", obj.getPrice1());
			jsonObject.addProperty("price2", obj.getPrice2());
			jsonObject.addProperty("price3", obj.getPrice3());
			jsonObject.addProperty("price4", obj.getPrice4());
			jsonObject.addProperty("price5", obj.getPrice5());
			jsonObject.addProperty("totalPrice", obj.getTotalPrice());
	        try {
				resultList.add(om.readValue(jsonObject.toString(), HashMap.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
		return resultList;
	}


	@Override
	public List<HashMap> getListWithTotalPriceByStoreAndTargetAreaId(long storeId, long targetAreaId, double weight) {
        Area areaInfo = areaManager.getById(targetAreaId);
        long targetCityId = areaInfo.getCityId();
        List<ExpressPrice> expressPriceList = expressPriceManager.getExpressPriceListByStoreIdAndTargetCityId(storeId, targetCityId);
        if (expressPriceList == null || expressPriceList.size() == 0) {
            //到市一级没有数据，取到省一级的。
            City cityInfo = cityManager.getById(targetCityId);
            expressPriceList = expressPriceManager.getExpressPriceListByStoreIdAndTargetProvinceId(storeId, cityInfo.getProvinceId().longValue());
        }
        List<HashMap> resultList = new ArrayList<HashMap>();
        if (expressPriceList == null || expressPriceList.size() == 0) {
            //空，没有数据
            return resultList;
        }
        ObjectMapper om = new ObjectMapper();
        for (ExpressPrice obj : expressPriceList) {
            double baseWeight = 1.0;
            double tmpWeight = weight - baseWeight;
            
            if (weight <= baseWeight) {
                obj.setTotalPrice(obj.getPrice1().longValue());
            }else {
            	obj.setTotalPrice((long)(obj.getPrice1().longValue() + tmpWeight*obj.getPrice2().longValue()));
            }
            JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", obj.getId());
			jsonObject.addProperty("expressId", obj.getExpressid());
			jsonObject.addProperty("sourceProvinceId", obj.getSourceprovinceid());
			jsonObject.addProperty("sourceCityId", obj.getSourcecityid());
			jsonObject.addProperty("sourceAreaId", obj.getSourceareaid());
			jsonObject.addProperty("sourceStoreId", obj.getSourcestoreid());
			jsonObject.addProperty("targetProvinceId", obj.getTargetprovinceid());
			jsonObject.addProperty("targetCityId", obj.getTargetcityid());
			jsonObject.addProperty("targetAreaId", obj.getTargetareaid());
			jsonObject.addProperty("targetStoreId", obj.getTargetstoreid());
			jsonObject.addProperty("price1", obj.getPrice1());
			jsonObject.addProperty("price2", obj.getPrice2());
			jsonObject.addProperty("price3", obj.getPrice3());
			jsonObject.addProperty("price4", obj.getPrice4());
			jsonObject.addProperty("price5", obj.getPrice5());
			jsonObject.addProperty("totalPrice", obj.getTotalPrice());
	        try {
				resultList.add(om.readValue(jsonObject.toString(), HashMap.class));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }
		return resultList;
	}


	@Override
	public List<HashMap> getListByStoreAndArea(long storeId, long fromAreaId,
			long toAreaId, double weight, double ceilWeight) {
		
		List<HashMap> resultList = new ArrayList<>();
		if(storeId == 0 || fromAreaId == 0 || toAreaId == 0) {
			return resultList;
		} else {
			Area areaInfo = areaManager.getById(toAreaId);
			City cityInfo = cityManager.getById(areaInfo.getCityId().longValue());
			List<ExpressPrice> expressPriceList1 = expressPriceManager.getExpressPriceListByStoreIdAndTargetProvinceId(storeId, cityInfo.getProvinceId().longValue());
			List<ExpressPrice> expressPriceList2 = expressPriceManager.getExpressPriceListByStoreIdAndTargetCityId(storeId, areaInfo.getCityId().longValue());
			
			Map<Long, ExpressPrice> expressPriceMap = new HashMap<>();
			for(ExpressPrice expressPrice : expressPriceList1) {
				expressPriceMap.put(expressPrice.getExpressid().longValue(), expressPrice);
			}
			for(ExpressPrice expressPrice : expressPriceList2) {
				expressPriceMap.put(expressPrice.getExpressid().longValue(), expressPrice);
			}
			
			ObjectMapper om = new ObjectMapper();
			for(long expressId : expressPriceMap.keySet()) {
				ExpressPrice obj = expressPriceMap.get(expressId);
				if(weight != 0.0d) {
					obj.setTotalPrice(obj.calcTotalPrice(ceilWeight));
				}
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("id", obj.getId());
				jsonObject.addProperty("expressId", obj.getExpressid());
				jsonObject.addProperty("sourceProvinceId", obj.getSourceprovinceid());
				jsonObject.addProperty("sourceCityId", obj.getSourcecityid());
				jsonObject.addProperty("sourceAreaId", obj.getSourceareaid());
				jsonObject.addProperty("sourceStoreId", obj.getSourcestoreid());
				jsonObject.addProperty("targetProvinceId", obj.getTargetprovinceid());
				jsonObject.addProperty("targetCityId", obj.getTargetcityid());
				jsonObject.addProperty("targetAreaId", obj.getTargetareaid());
				jsonObject.addProperty("targetStoreId", obj.getTargetstoreid());
				jsonObject.addProperty("price1", obj.getPrice1());
				jsonObject.addProperty("price2", obj.getPrice2());
				jsonObject.addProperty("price3", obj.getPrice3());
				jsonObject.addProperty("price4", obj.getPrice4());
				jsonObject.addProperty("price5", obj.getPrice5());
				jsonObject.addProperty("totalPrice", obj.getTotalPrice());
				try {
					resultList.add(om.readValue(jsonObject.toString(), HashMap.class));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			ExpressPriceSf obj = expressPriceSfManager.getByFromAreaIdAndToAreaId(fromAreaId, toAreaId);
			if(weight != 0.0d) {
				obj.setTotalPrice(obj.calcTotalPrice(weight));
			}
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("id", obj.getId());
			jsonObject.addProperty("expressId", 18);
			jsonObject.addProperty("fromAreaId", obj.getFromareaid());
			jsonObject.addProperty("toAreaId", obj.getToareaid());
			jsonObject.addProperty("price1", obj.getPrice1());
			jsonObject.addProperty("price2", obj.getPrice2());
			jsonObject.addProperty("price3", obj.getPrice3());
			jsonObject.addProperty("price4", obj.getPrice4());
			jsonObject.addProperty("price5", obj.getPrice5());
			jsonObject.addProperty("landPrice1", obj.getLandprice1());
			jsonObject.addProperty("landPrice2", obj.getLandprice2());
			jsonObject.addProperty("landPrice3", obj.getLandprice3());
			jsonObject.addProperty("landPrice4", obj.getLandprice4());
			jsonObject.addProperty("landPrice5", obj.getLandprice5());
			jsonObject.addProperty("totalPrice", obj.getTotalPrice());
			try {
				resultList.add(om.readValue(jsonObject.toString(), HashMap.class));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}

}
