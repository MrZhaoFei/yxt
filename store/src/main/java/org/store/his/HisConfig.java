package org.store.his;

public class HisConfig {
	private static String account;
	private static String password;
	private static String publicKey;
	private static String url;

	public static void setAccount(String account) {
		HisConfig.account = account;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		HisConfig.password = password;
	}

	public static String getPublicKey() {
		return publicKey;
	}

	public static void setPublicKey(String publicKey) {
		HisConfig.publicKey = publicKey;
	}

	public static String getAccount() {
		return account;
	}

	public static String getUrl() {
		return url;
	}

	public static void setUrl(String url) {
		HisConfig.url = url;
	}

}
