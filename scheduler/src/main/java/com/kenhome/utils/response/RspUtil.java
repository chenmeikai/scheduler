package com.kenhome.utils.response;

import com.alibaba.fastjson.JSONObject;

public class RspUtil {
	
	private final static int successCode = 200;
	private final static int errorCode = 100;
	private final static String successMessage = "success";
	private final static String errorMessage = "error";

	public static <T> BaseResponse<T> success(T data) {
		BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setData(data);
        rsp.setDesc(successMessage);
        rsp.setCode(successCode);
		return rsp;
	}
	
	public static <T> BaseResponse<T> success(String msg) {
		BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setDesc(msg);
        rsp.setCode(successCode);
		return rsp;
	}
	
	public static <T> BaseResponse<T> success(Integer code,String msg) {
        BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setDesc(msg);
        rsp.setCode(code);
        return rsp;
    }

	public static <T> BaseResponse<T> success(String msg,T data) {
		BaseResponse<T> rsp = new BaseResponse<T>();
		rsp.setData(data);
		rsp.setDesc(msg);
		rsp.setCode(successCode);
		return rsp;
	}
	
	public static <T> BaseResponse<T> success(Integer code,String msg,T data) {
		BaseResponse<T> rsp = new BaseResponse<T>();
		rsp.setData(data);
		rsp.setDesc(msg);
		rsp.setCode(code);
		return rsp;
	}

	public static <T> BaseResponse<T> success() {
		BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setDesc(successMessage);
        rsp.setCode(successCode);
		return rsp;
	}

	public static <T> BaseResponse<T> error() {
		BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setDesc(errorMessage);
        rsp.setCode(errorCode);
		return rsp;
	}


	public static <T> BaseResponse<T> error(Integer code,String msg) {
		BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setDesc(msg);
        rsp.setCode(code);
		return rsp;
	}

	public static <T> BaseResponse<T> error(String msg,int code) {
		BaseResponse<T> rsp = new BaseResponse<T>();
        rsp.setDesc(msg);
        rsp.setCode(code);
		return rsp;
	}

	public static <T> BaseResponse<T> error(String msg) {
		BaseResponse<T> rsp = new BaseResponse<T>();
		rsp.setDesc(msg);
		rsp.setCode(errorCode);
		return rsp;
	}

	public static String errorStr(String msg) {
		JSONObject json = new JSONObject();
		json.put("code", "-2");
		json.put("desc", msg);
		return json.toJSONString();
	}
}
