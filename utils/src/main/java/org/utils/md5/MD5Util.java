package org.utils.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Util
 * @author <font color="red"><b>LiuGangQiang</b></font>
 * @date 2016年1月31日 上午10:48:10
 * @version 1.0
 * @description MD5加密解密
 */
public class MD5Util {
	private static MD5Util instance = new MD5Util();

	private MD5Util() {
	}

	public static MD5Util getInstance() {
		if (null == instance) {
			instance = new MD5Util();
		}
		return instance;
	}

	/**
	 * @param inStr
	 * @return {@link String}
	 * @version 1.0
	 * @date 2016年1月31日 上午10:49:20
	 * @description 得到MD5加密字符串
	 */
	public String getMD5Code(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return "";
		}
		byte[] md5Bytes = md5.digest(inStr.getBytes());
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString().toUpperCase();
	}

	/**
	 * @param inStr
	 * @return {@link String}
	 * @version 1.0
	 * @date 2016年1月31日 上午10:50:36
	 * @description 解密MD5字符串
	 */
	public String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		return new String(a);

	}
}
