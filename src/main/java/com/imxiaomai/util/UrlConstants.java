package com.imxiaomai.util;

import com.imxiaomai.base.infrastructure.Config;

public class UrlConstants {

	public static final String baifen_sname = Config.of("baifen_sname","dlyizukk").get();

	public static final String baifen_spwd = Config.of("baifen_spwd","Oy6wboz8").get();

	public static final String baifen_scorpid = Config.of("baifen_scorpid","").get();

	public static final String baifen_sprdid = Config.of("baifen_sprdid","1012818").get();

	public static final String baifen_sdst = Config.of("baifen_sdst","").get();

	public static final String baifen_smsg = Config.of("baifen_smsg","").get();

	public static final String md_sn = Config.of("md_sn","SDK-BBX-010-21574").get();

	public static final String md_pwd = Config.of("md_pwd", "5272=3-=").get();

	public static final String md_sendUrl = Config.of("md_sendUrl","http://sdk.entinfo.cn:8061/mdsmssend.ashx").get();

	public static final String md_getStatus = Config.of("md_statusUrl","http://report.zucp.net:8060/reportservice.asmx/report").get();


	/* ---------------------- 营销产品通道 切记不要用混 --------------------*/
	public static final String marking_sname = Config.of("marking_sname","dlyizu00").get();

	public static final String marking_spwd = Config.of("marking_spwd","abobo123").get();

	public static final String marking_scorpid = Config.of("marking_scorpid","").get();

	public static final String marking_sprdid = Config.of("marking_sprdid","1012812").get();

}