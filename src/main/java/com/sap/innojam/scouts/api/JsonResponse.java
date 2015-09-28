package com.sap.innojam.scouts.api;

import javax.xml.bind.annotation.XmlRootElement;

//TODO: think where to move it.
@XmlRootElement
public class JsonResponse {
	private String status;
	private String msg;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
