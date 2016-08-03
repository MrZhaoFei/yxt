package org.core.result;

import java.util.HashMap;
import java.util.Map;

import org.core.message.java.SystemMessage;

public class ResultMap {

	/**
	 * 采用内定消息 有数据实体
	 * 
	 * @param code
	 * @param data
	 * @return {@link Map}
	 */
	public static Map<String, Object> convertMap(CodeEnum code, Object data) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SystemMessage.bundle("result.code.key"), code.getValue());
		map.put(SystemMessage.bundle("result.date.key"), data);
		map.put(SystemMessage.bundle("result.message.key"), code.getMessage());
		return map;
	}

	/**
	 * 采用自定义消息 有数据实体
	 * 
	 * @param code
	 * @param data
	 * @param message
	 * @return {@link Map}
	 */
	public static Map<String, Object> convertMap(CodeEnum code, Object data, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SystemMessage.bundle("result.code.key"), code.getValue());
		map.put(SystemMessage.bundle("result.date.key"), data);
		map.put(SystemMessage.bundle("result.message.key"), message);
		return map;
	}

	/**
	 * 采用自定义消息 无数据实体
	 * 
	 * @param code
	 * @param message
	 * @return {@link Map}
	 */
	public static Map<String, Object> convertMap(CodeEnum code, String message) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SystemMessage.bundle("result.code.key"), code.getValue());
		map.put(SystemMessage.bundle("result.message.key"), message);
		return map;
	}

	/**
	 * 采用内定消息 无数据实体
	 * 
	 * @param code
	 * @return {@link Map}
	 */
	public static Map<String, Object> convertMap(CodeEnum code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(SystemMessage.bundle("result.code.key"), code.getValue());
		map.put(SystemMessage.bundle("result.message.key"), code.getMessage());
		return map;
	}

}
