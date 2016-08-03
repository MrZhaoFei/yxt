package org.store.phone;

import java.util.HashMap;
import java.util.Map;

import org.utils.code.RSAUtils;

import com.alibaba.fastjson.JSON;

public class PhoneFactory {
	private static PhoneFactory instance = null;

	private PhoneFactory() {
	}

	public static PhoneFactory getInstance() {
		if (instance == null) {
			instance = new PhoneFactory();
		}
		return instance;
	}

	public Map<String, Object> getPermissionToken(int acquisitive) {
		Map<String, Object> permissionMap = new HashMap<>();
		Map<String, Object> resultMap = new HashMap<>();
		long time = System.currentTimeMillis();
		permissionMap.put("account", PhoneConfig.getAccount());
		permissionMap.put("password", PhoneConfig.getPassword());
		permissionMap.put("createDate", time);
		permissionMap.put("acquisitive", acquisitive <= 0 ? 1 : acquisitive);

		resultMap.put("token", RSAUtils.RSAEncode(RSAUtils.getPublicKey(PhoneConfig.getPublicKey()),
				JSON.toJSONString(permissionMap)));
		resultMap.put("acquisitive", acquisitive);
		resultMap.put("createDate", time);
		resultMap.put("url", PhoneConfig.getUrl());
		return resultMap;
	}

	public String getPermissionTokenString(int acquisitive) {
		Map<String, Object> permissionMap = new HashMap<>();
		long time = System.currentTimeMillis();
		permissionMap.put("account", PhoneConfig.getAccount());
		permissionMap.put("password", PhoneConfig.getPassword());
		permissionMap.put("createDate", time);
		permissionMap.put("acquisitive", acquisitive <= 0 ? 1 : acquisitive);

		return RSAUtils.RSAEncode(RSAUtils.getPublicKey(PhoneConfig.getPublicKey()), JSON.toJSONString(permissionMap));
	}
}
