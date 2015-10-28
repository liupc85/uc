package com.imxiaomai.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imxiaomai.dao.AreaDao;
import com.imxiaomai.dao.CityDao;
//import com.imxiaomai.fw.client.codis.CommonClient;
//import com.imxiaomai.fw.client.codis.pool.PoolType;

import com.imxiaomai.manager.ProvinceManager;
//import com.imxiaomai.persistence.domain.Area;
//import com.imxiaomai.persistence.domain.Province;
import com.imxiaomai.service.AreaService;
import com.imxiaomai.service.StoreService;


@Controller
public class Test {

	@Resource 
	private AreaService areaService;
	
	@Resource 
	private StoreService storeService;
	
	@Resource
	private ProvinceManager provinceManager;
	
	@Autowired private  AreaDao areaDao;
	@Autowired private  CityDao cityDao;
	@RequestMapping("/main/test")

	public void test(){
		System.out.println("22222");
		
		System.out.println(storeService.getAll());
		
//		
//		
//		Area a=areaDao.getById(1);
//		System.out.println("----------------"+a.getName());
//		List<Area> list=areaDao.getAll();
//		System.out.println("zzzzzzzzzzzzz "+list.size());
		
//		List<Area> list2=areaDao.getByCityId(2L);
//		long pid=1L;
//		System.out.println((cityDao.getByProvinceId(pid)).size());
//		System.out.println("-----------------"+cityDao.getAll().size());
		
//		userDao.updateByPair("userName", "dao测试qqq1111", 172);
//		userStatDao.updateByPair("mac", "11111111111111111111", 2);
//		expressDao.updateKey("name", "dao测试", 17);
//		courierDeviceDao.updateByPair("version", "1.1.1.1", 1318);
//		courierMideviceDao.updateByPair("version", "1.1.1", 12);
//		deviceDao.updateByPair("version", "1.1.1", 18);
//		mideviceDao.updateByPair("version", "1.1", 1);
//		collegeDao.getAllWithColleges();
//		System.out.println("_________ "+list2.size());
		
	}
	
/*	
	@RequestMapping("/redis/value")
	@ResponseBody
	public Object testKey(HttpServletRequest request) throws SQLException, IOException{
		String name = request.getParameter("name");
		String value = request.getParameter("name");
		CommonClient commonClient = new CommonClient(PoolType.roundRobin,3);
		commonClient.set(name, value);
		return "the key of:"+name+" is:" + commonClient.get(name);
	}
	
	@RequestMapping("/redis/model")
	@ResponseBody
	public Object testModel(HttpServletRequest request) throws SQLException, IOException{
		Province p = this.provinceManager.getById(1L);
		String name = request.getParameter("name");	
		CommonClient commonClient = new CommonClient(PoolType.roundRobin,3);
		//commonClient.set(name.getBytes(), p);
		commonClient.set(name.getBytes(), this.serialize(p));
		
		byte[] pp = commonClient.get(name.getBytes());
		Province p3 = (Province) this.unserialize(pp);
		return p3;
	}*/
	
	public  byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
		//序列化
		baos = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		byte[] bytes = baos.toByteArray();
		return bytes;
		} catch (Exception e) {
		 
		}
		return null;
	}
	
	public Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
		//反序列化
		bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		return ois.readObject();
		} catch (Exception e) {
		 
		}
		return null;
	}
}

