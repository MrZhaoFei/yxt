package org.core.result;

public enum CodeEnum {
	
	SUCCESS(200, "操作成功"), 
	FAIL(202, "操作失败"),
	UNAUTHORIZED(403,"无权限操作"),
	PARAMETER_ERROR(400,"参数有误"),
	UNSIGNATURE(401,"签名错误，请重新登录获取签名"),
	DATA_UNEXIST(404,"数据不存在"),
	DATA_EXIST(409,"数据已存在"),
	SYSTEM_ERROR(500, "系统内部异常");
	
	private final int value;
	private final String message;

	public int getValue() {
		return value;
	}

	public String getMessage() {
		return message;
	}

	CodeEnum(int value, String message) {
		this.value = value;
		this.message = message;
	}
}
