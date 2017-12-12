package com.xb.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="logaop")
public class LogPojo {
	private String id;
	private String method;
	private String paramVal;
	private String returnval;
	private String implUrl;
	private String cztime;
	
	private String starttime;
	private String endtime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParamVal() {
		return paramVal;
	}
	public void setParamVal(String paramVal) {
		this.paramVal = paramVal;
	}
	public String getReturnval() {
		return returnval;
	}
	public void setReturnval(String returnval) {
		this.returnval = returnval;
	}
	public String getImplUrl() {
		return implUrl;
	}
	public void setImplUrl(String implUrl) {
		this.implUrl = implUrl;
	}
	public String getCztime() {
		return cztime;
	}
	public void setCztime(String cztime) {
		this.cztime = cztime;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}
