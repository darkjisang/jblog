package com.javaex.vo;

import org.springframework.stereotype.Component;

@Component
public class JsonResult {
	private String result;	//success or fail
	private Object data;	//성공시 보낼 값 result = success
	private String failMsg;	//실패시 보낼 값 result = fail 참고 메시지
	
	public JsonResult() {
		super();
	}

	public JsonResult(String result, Object data, String failMsg) {
		super();
		this.result = result;
		this.data = data;
		this.failMsg = failMsg;
	}
	
	//일반 메서드
	//성공시
	public void success(Object data) {
		this.result = "success";
		this.data = data;
	}

	//실패시
	public void fail(String msg) {
		this.result = "fail";
		this.failMsg = msg;
	}
	
	//get/set
	public String getResult() {
		return result;
	}

	public Object getData() {
		return data;
	}

	public String getFailMsg() {
		return failMsg;
	}

	@Override
	public String toString() {
		return "JsonResult [result=" + result + ", data=" + data + ", failMsg=" + failMsg + "]";
	}
	
}