package org.utils.code;

import java.util.UUID;

public class IDWork {

	private static IDWork instance = null;
	private final static char[] DIGITS64 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	private IDWork() {
	}

	public static IDWork getInstance() {
		if (instance == null) {
			instance = new IDWork();
		}
		return instance;
	}

	public String getId() {
		UUID u = UUID.randomUUID();
		long l = u.getMostSignificantBits();
		char[] buf = "00000000000".toCharArray(); // 限定11位长度
		int length = 11;
		long least = 35L; // 0x0000003FL
		do {
			buf[--length] = DIGITS64[(int) (l & least)];
			l >>>= 6;
		} while (l != 0);
		return new String(buf);
	}

	public String getUUID() {
		return getId() + getId();
	}
}
