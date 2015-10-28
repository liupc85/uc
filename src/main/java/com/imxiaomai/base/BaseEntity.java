package com.imxiaomai.base;

import com.google.gson.JsonObject;
import com.imxiaomai.base.util.Jsoned;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable, Cloneable, Jsoned{


	private static final long serialVersionUID = 1L;

	protected static Date time(long time) {
		return new Date(time);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public BaseEntity clone() {
		try {
			return (BaseEntity) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
