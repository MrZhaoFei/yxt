package org.system;

public class Global {

	// 用户信息缓存
	public static final String CACHE_USER = "userCache";
	// 医生信息缓存
	public static final String CACHE_DOCTOR = "doctorCache";
	// 验证码缓存 Ehcache
	public static final String CACHE_CODE = "codeCache";
	// 验证码缓存 Session
	public static final String SESSION_CODE = "validCode";

	// 记录总数标识
	public static final String DATA_TOTAL = "total";
	// 记录主体标识
	public static final String DATA_ROWS = "rows";
}
