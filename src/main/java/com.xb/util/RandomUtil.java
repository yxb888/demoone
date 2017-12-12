package com.xb.util;

import java.util.Random;

public class RandomUtil {
	private static Random random = new Random();
	
	public static String getRandomCode(int len) {
		String code = "";
		for (int i = 0; i < len; i++) {
			code += random.nextInt(10);
		}
		return code;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(getRandomCode(10));
		}
	}
}
