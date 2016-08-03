package org.store.his;

import java.util.HashMap;
import java.util.Map;

import org.utils.code.RSAUtils;

import com.alibaba.fastjson.JSON;

public class HisFactory {
	private static HisFactory instance = null;

	private HisFactory() {
	}

	public static HisFactory getInstance() {
		if (instance == null) {
			instance = new HisFactory();
		}
		return instance;
	}

	public Map<String, Object> getPermissionToken(int acquisitive) {
		Map<String, Object> permissionMap = new HashMap<>();
		Map<String, Object> resultMap = new HashMap<>();
		long time = System.currentTimeMillis();
		permissionMap.put("account", HisConfig.getAccount());
		permissionMap.put("password", HisConfig.getPassword());
		permissionMap.put("createDate", time);
		permissionMap.put("acquisitive", acquisitive <= 0 ? 1 : acquisitive);

		resultMap.put("token",
				RSAUtils.RSAEncode(RSAUtils.getPublicKey(HisConfig.getPublicKey()), JSON.toJSONString(permissionMap)));
		resultMap.put("acquisitive", acquisitive);
		resultMap.put("createDate", time);
		resultMap.put("url", HisConfig.getUrl());
		return resultMap;
	}

	public String getPermissionTokenString(int acquisitive) {
		Map<String, Object> permissionMap = new HashMap<>();
		long time = System.currentTimeMillis();
		permissionMap.put("account", HisConfig.getAccount());
		permissionMap.put("password", HisConfig.getPassword());
		permissionMap.put("createDate", time);
		permissionMap.put("acquisitive", acquisitive <= 0 ? 1 : acquisitive);

		return RSAUtils.RSAEncode(RSAUtils.getPublicKey(HisConfig.getPublicKey()), JSON.toJSONString(permissionMap));
	}
}
