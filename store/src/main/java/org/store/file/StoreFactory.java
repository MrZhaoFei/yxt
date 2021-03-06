package org.store.file;

import java.util.HashMap;
import java.util.Map;

import org.utils.code.RSAUtils;

import com.alibaba.fastjson.JSON;

public class StoreFactory {
	private static StoreFactory instance = null;

	private StoreFactory() {
	}

	public static StoreFactory getInstance() {
		if (instance == null) {
			instance = new StoreFactory();
		}
		return instance;
	}

	public Map<String, Object> getPermissionToken(int acquisitive) {
		Map<String, Object> permissionMap = new HashMap<>();
		Map<String, Object> resultMap = new HashMap<>();
		long time = System.currentTimeMillis();
		permissionMap.put("account", StoreConfig.getAccount());
		permissionMap.put("password", StoreConfig.getPassword());
		permissionMap.put("createDate", time);
		permissionMap.put("acquisitive", acquisitive <= 0 ? 1 : acquisitive);

		resultMap.put("token", RSAUtils.RSAEncode(RSAUtils.getPublicKey(StoreConfig.getPublicKey()),
				JSON.toJSONString(permissionMap)));
		resultMap.put("acquisitive", acquisitive);
		resultMap.put("createDate", time);
		resultMap.put("url", StoreConfig.getUrl());
		return resultMap;
	}

	public String getPermissionTokenString(int acquisitive) {
		Map<String, Object> permissionMap = new HashMap<>();
		long time = System.currentTimeMillis();
		permissionMap.put("account", StoreConfig.getAccount());
		permissionMap.put("password", StoreConfig.getPassword());
		permissionMap.put("createDate", time);
		permissionMap.put("acquisitive", acquisitive <= 0 ? 1 : acquisitive);
		return RSAUtils.RSAEncode(RSAUtils.getPublicKey(StoreConfig.getPublicKey()), JSON.toJSONString(permissionMap));
	}
}
