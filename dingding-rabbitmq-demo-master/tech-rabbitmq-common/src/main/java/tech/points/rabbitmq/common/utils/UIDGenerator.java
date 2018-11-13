package tech.points.rabbitmq.common.utils;

import java.util.Random;

/**
 * Generate the unique key
 * 
 * @Author: Eddie.Wei
 * @Date: 2018-10-09
 * @github: https://github.com/weixuan2008
 */
public class UIDGenerator {
	public static synchronized String genProductID() {
		Random random = new Random();
		Integer number = random.nextInt(900000) + 100000;

		return System.currentTimeMillis() + String.valueOf(number);
	}

	public static synchronized String genCompanyID() {
		Random random = new Random();
		Integer number = random.nextInt(9000000) + 1000000;

		return String.valueOf(number);
	}
}
