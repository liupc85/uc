package com.imxiaomai.web;

import static com.imxiaomai.base._.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Function;
import com.imxiaomai.base.toolkit.CollUtil;
import com.imxiaomai.base.util.JsonUtil;
import com.imxiaomai.constants.UpgradeConstant;
//import com.imxiaomai.entity.Upgrade;
//import com.imxiaomai.entity.UpgradePloy;
//import com.imxiaomai.entity.User;
//import com.imxiaomai.entity.UserStat;
//import com.imxiaomai.entity.Versions;
import com.imxiaomai.persistence.domain.Upgrade;
import com.imxiaomai.persistence.domain.UpgradePloy;
import com.imxiaomai.persistence.domain.User;
import com.imxiaomai.persistence.domain.Versions;
import com.imxiaomai.service.UserService;
import com.imxiaomai.service.UserStatService;
import com.imxiaomai.service.UpgradeService;
import com.imxiaomai.service.UpgradePloyService;
import com.imxiaomai.service.VersionsService;
import com.imxiaomai.web.base.BaseController;

@Controller
public class VersionAction extends BaseController{

	@Autowired UserService userService;
	
	@Autowired UserStatService userStatService;
	
	@Autowired VersionsService versionsService;
	
	@Autowired UpgradeService upgradeService;
	
	@Autowired UpgradePloyService upgradePloyService;
	
	//获取最新app版本：url传参数。pubType为版本类型(正式版，测试版)，type为app类型(app,bar,plantform,allineone)
	@RequestMapping("/version/{pubType:[\\w]+}/{type:[\\w]+}")
    @ResponseBody
    public Object versionInterface(HttpServletRequest request, @PathVariable String pubType, @PathVariable String type) throws SQLException {
//		Versions versions = Versions.getNewestOne(type, pubType);
		Versions versions =versionsService.getNewestOne(type, pubType);
		if( versions == null ){
			return buildJson(-1,"查询失败");
		}
		return buildJson(0,"",versions);
    }
    
	//此接口默认请求type=app, pubType=pub
	@RequestMapping("/app/version")
	@ResponseBody
	public Object getVersion(HttpServletRequest request) throws SQLException, IOException {
		String data = getDataFromRequest(request);
		Versions versions = null;
		String type = "app";
		if( data != null){
			JsonNode jsonNode = JsonUtil.parse(data);
			if( jsonNode != null ){
				String versionCode = jsonNode.findValue("versionCode") != null ? jsonNode.findValue("versionCode").asText() : "";
				String uid = jsonNode.findValue("uid")!=null?jsonNode.findValue("uid").asText():"";
				String mac = jsonNode.findValue("mac")!=null?jsonNode.findValue("mac").asText():"";
				String uuid = jsonNode.findValue("uuid")!=null?jsonNode.findValue("uuid").asText():"";
				long userId = jsonNode.findValue("userId")!=null? jsonNode.findValue("userId").asLong():0;
				String channel = jsonNode.findValue("channel")!=null? jsonNode.findValue("channel").asText() : "";
				String packageName = jsonNode.findValue("packageName") == null ? "com.xiaomai.express" : jsonNode.findValue("packageName").asText();
				if (userId>0) {
//					UserStat.updateVersionCode(versionCode, uid, mac, uuid, userId, new Date()) ;
					userStatService.updateVersionCode(versionCode, uid, mac, uuid, userId, new Date());
				}
				if( !"com.xiaomai.express".equals(packageName) ){
					type = "courier_app";
				}
//				User user = User.getById(userId);
				User user = userService.getById(userId);
				if(user ==null){
					return buildJson(-1,"查询失败");
				}
				boolean isUpgrade = true;
				List<Long> vids = getVid(Long.parseLong(versionCode));
				System.out.println("vids "+vids );
				if(isNotEmpty(vids)){
					System.out.println("vids.size() "+vids.size() );
					List<Long> remove = new ArrayList<>();
					for(Long vid : vids){
						List<UpgradePloy> list = getKV(vid);  // 为空代表没有过滤条件
						if(isNotEmpty(list))
							isUpgrade = filter(userId, user.getCollegeid(), versionCode, user.getMobilephone(), channel, list);
						if(!isUpgrade){	
							remove.add(vid);
							isUpgrade = true;  // 过滤条件每次要设置回来，
						}
					}
					vids.removeAll(remove);
				}
				System.out.println("vids after xiugai "+vids );
				if(isNotEmpty(vids)){
					System.out.println("vids after xiugai "+vids.size() );
					Collections.sort(vids);
//					versions = Versions.getById(vids.get(vids.size()-1), type, "pub");
					versions = versionsService.getById(vids.get(vids.size()-1), type, "pub");
//					System.out.println( "versionCode=" + versionCode + ",versions.version=" + versions.version + ",compare=" + String.CASE_INSENSITIVE_ORDER.compare(versionCode,versions.version));
//					if( isNotEmpty(versionCode) && String.CASE_INSENSITIVE_ORDER.compare(versionCode,versions.version) >= 0)
//						versions.flag = 0;
				}
				if(versions == null){
//					versions = Versions.getNewestOne(type, "pub");
					versions=versionsService.getNewestOne(type, "pub");
					if(versions!=null){
						int flag=versions.getFlag();//先取出flag值
						versions.setFlag(0);
						if(toInt(versions.getVersion()) > toInt(versionCode) && versions.getFlag()== 0&&flag==2){
//							versions.flag = 1;
							//flag等于2，强制升级
							versions.setFlag(flag);
						}else if(toInt(versions.getVersion()) > toInt(versionCode) && versions.getFlag()== 0){
							versions.setFlag(1);
						}
					}


				}
			}
		}

		if( versions == null ){
			return buildJson(-1,"查询失败");
		}
		return buildJson(0,"",versions);

	}
	
	


	//此接口合并到versionInterface中了
	/*@RequestMapping("/platform/version")
	@ResponseBody
	public Object getPlantVersion(HttpServletRequest request) throws SQLException {
		Versions versions = Versions.getNewestOne("plantform");
		if( versions == null ){
			return buildJson(-1,"查询失败");
		}
		return buildRetJson(0,"",versions);

	}*/
	
	/**
	 * 通过version值获得能够升级的vid
	 * @param version
	 * @return
	 * @throws SQLException
	 */
	private List<Long> getVid(final long version) throws SQLException{
//		List<Upgrade> list = Upgrade.selectLargeVersion(version);
		List<Upgrade> list = upgradeService.selectLargeVersion(version);
		if(isNotEmpty(list)){
			return CollUtil.mapNotNull(list, new Function<Upgrade, Long>() {

				@Override
				public Long apply(Upgrade input) {
					return new Long(input.getVid());
				}
			});
		}
		return null;
	}
	
	/**
	 * 得到升级的key-value
	 * @param ug
	 * @return
	 * @throws SQLException
	 */
	private List<UpgradePloy> getKV(final long vid) throws SQLException{
//		List<Upgrade> ug = Upgrade.selectByVid(vid);
		List<Upgrade> ug = upgradeService.selectByVid(vid);
		List<UpgradePloy> list = new ArrayList<>();	
		if(isEmpty(ug))
			return list;
		for(Upgrade upgrade : ug){
//			UpgradePloy up = UpgradePloy.select(upgrade.getOpid());
			UpgradePloy up = upgradePloyService.select(upgrade.getOpid());
			if(up != null)
				list.add(up);
		}
		return list;
	}
	
	
	/**
	 * 过滤每个组合
	 * @param uid
	 * @param collegeId
	 * @param version
	 * @param phone
	 * @param channel
	 * @param list
	 * @return true represent match
	 * 
	 * todo..  支持多个学校有问题fix
	 */
	private boolean filter(final long userId, final long collegeId, final String version, final String phone, final String channel, List<UpgradePloy> list){
		boolean _channel = false;  // 支持多个渠道,或的关系
		boolean _channel_visit = false;  // 判断升级条件中是否有渠道这个条件,与的关系
		boolean _school = false;
		boolean _school_visit = false;
		boolean _version = false;
		boolean _version_visit = false;
		boolean _percent = false;
		boolean _percent_visit = false;
		boolean _telphone = false;
		boolean _telphone_visit = false;
		for(UpgradePloy up : list){    // 对每个版本 的所以op进行判断
			switch(up.getUpgradename()){
				case UpgradeConstant.CHANNEL :
					if(up.getUpgradevalue().equalsIgnoreCase(channel))
						_channel = true;  // 有一个渠道ok，就ok了
					_channel_visit = true;  // 表示channel已经出现
					break;
				case UpgradeConstant.SCHOOL :
					if(Long.parseLong(up.getUpgradevalue()) == collegeId)
						_school = true;
					_school_visit = true;
					break;
				case UpgradeConstant.VERSION :
					if(Long.parseLong(version) == Long.parseLong(up.getUpgradevalue()))
						_version = true;
					_version_visit = true;
					break;
				case UpgradeConstant.PERCENT :
					if(userId % Long.parseLong(up.getUpgradevalue()) == 0)   // todo 不能做到公平性，想加个比模小的随机数，使其得到公平性，这样就没有可重复性了。
						_percent = true;
					_percent_visit = true;
					break;
				case UpgradeConstant.TELPHONE :
					if(phone.equalsIgnoreCase(up.getUpgradevalue()))
						_telphone = true;
					_telphone_visit = true;
					break;
			}
		}
		if(((_channel)||!_channel_visit)&&(_school||!_school_visit)&&(_version||!_version_visit)&&(_telphone||!_telphone_visit)&&(_percent||!_percent_visit)){
			return true;
		}
		return false;
	}

}
