package com.wcc.services.distance.util;

public class MathUtil {

	public static double haversine(double deg1, double deg2) {
		double sin = Math.sin((deg1 - deg2) / 2.0);
		return Math.pow(sin, 2);
	}
}