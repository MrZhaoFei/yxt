package org.store.phone;

public class PhoneConfig {
	private static String account;
	private static String password;
	private static String publicKey;
	private static String url;

	public static void setAccount(String account) {
		PhoneConfig.account = account;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		PhoneConfig.password = password;
	}

	public static String getPublicKey() {
		return publicKey;
	}

	public static void setPublicKey(String publicKey) {
		PhoneConfig.publicKey = publicKey;
	}

	public static String getAccount() {
		return account;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		PhoneConfig.url = url;
	}

}
