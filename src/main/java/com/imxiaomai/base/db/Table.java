package com.imxiaomai.base.db;

import com.imxiaomai.constants.DBConfig;
import com.imxiaomai.entity.*;

public class Table {

	/* ------------------------- enums ------------------------- */
	public static final DBType1<User> userDB = of(User.class,"user");
    public static final DBType1<WxUnBindUser> wxUnBindUserDB = of(WxUnBindUser.class, "wx_bind_user");	
	public static final DBType1<UserStat> userStatDB = of(UserStat.class,"userStat");
	public static final DBType1<DeviceInfo> deviceInfo = of(DeviceInfo.class,"device_info");
	public static final DBType1<CourierDeviceInfo> courierDeviceInfo = of(CourierDeviceInfo.class,"courier_device_info");
	public static final DBType1<CourierMiDevice> courierMiDevice = of(CourierMiDevice.class,"courier_midevice");
	public static final DBType1<MiDevice> miDevice = of(MiDevice.class,"midevice");
	public static final DBType1<AreaInfo> areaInfo = of(AreaInfo.class,"area_info");
	public static final DBType1<CityInfo> cityInfo = of(CityInfo.class,"city_info");
	public static final DBType1<CollegeInfo> collegeInfo = of(CollegeInfo.class,"college_info");
	public static final DBType1<ProvinceInfo> provinceInfo = of(ProvinceInfo.class,"province_info");
	public static final DBType1<CountryInfo> countryInfo = of(CountryInfo.class,"country_info");
	public static final DBType1<StoreInfo> storeInfo = of(StoreInfo.class,"store_info");
	public static final DBType1<StoreFavorable> storeFavorable = of(StoreFavorable.class,"storefavorable");
	public static final DBType1<ExpressPriceInfo> expressPriceInfo = of(ExpressPriceInfo.class,"expressPriceInfo");
	public static final DBType1<FeedBack> feedBack = of(FeedBack.class,"feedback");
	public static final DBType1<ScoreList> scoreList = of(ScoreList.class,"scoreList");
	public static final DBType1<Versions> versionDB = of(Versions.class,"versions");
	public static final DBType1<StoreExpress> storeExpressDB = of(StoreExpress.class,"storeExpress");
	public static final DBType1<ExpressPrice> expressPriceDB = of(ExpressPrice.class,"express_price");
	public static final DBType1<ExpressPriceSf> expressPriceSfDB = of(ExpressPriceSf.class,"express_price_sf");
	public static final DBType1<Upgrade> upgradeDB = of(Upgrade.class,"upgrade");
	public static final DBType1<UpgradePloy> upgradeployDB = of(UpgradePloy.class,"upgradeploy");
	public static final DBType1<SmsRecords> smsRecords = of(SmsRecords.class, "smsRecords");
	
	//zhagn-shuai
	public static final DBType1<StoreInfoExtend> storeInfoExtend = of(StoreInfoExtend.class,"store_info");
	public static final DBType1<ExpressInfo> expressInfo = of(ExpressInfo.class,"express_info");

	public static final DBType1<NewUser> newUserDB = of(NewUser.class, "new_user");
	public static final DBType1<IdPhone> idPhoneDB = of(IdPhone.class, "id_phone");
		
	
	/* ------------------------- fields ------------------------- */

	private static <T> DBType1<T> of(Class<T> type, String tab) {
		return new DBType1<T>(type, tab);
	}

	/**为保证所有分表的操作都按正确的方式写了sql，将分表/不分表从class级别就区分开 */
	public static class BaseDB<T> {
		protected final Class<T> type;
		protected final String tab;
		private ProxoolRunner db;
		public BaseDB(Class<T> type, String tab) {
			this.type = type;
			this.tab = tab;
		}

		protected ProxoolRunner db() {
			if (this.db == null)
				this.db = _getDb(tab);
			return this.db;
		}
	}

	static ProxoolRunner one;
	/*--------声明为public，方面调用-------------*/
	public static ProxoolRunner _getDb(String tab) {
		if (one == null)
			one = DBConfig.userDB;
		return one;
	}

}
