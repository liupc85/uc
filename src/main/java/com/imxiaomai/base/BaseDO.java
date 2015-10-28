package com.imxiaomai.base;

import java.io.Serializable;
import java.sql.SQLException;

import com.google.gson.JsonObject;
import com.imxiaomai.base.util.Jsoned;

public  class BaseDO implements Serializable{


	private static final long serialVersionUID = 441525532235975126L;
	
	public BaseDO clone() {
		try {
			return (BaseDO) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
