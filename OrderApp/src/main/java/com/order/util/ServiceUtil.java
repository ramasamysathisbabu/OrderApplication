package com.order.util;

import java.text.DecimalFormat;

public class ServiceUtil {
	private static final String FLOATING_TWO_DECIMAL_FORMAT = "#.##";
	
	public static float getFormattedFloatingValue(float orderTotalValue) {
		DecimalFormat df = new DecimalFormat(FLOATING_TWO_DECIMAL_FORMAT);
		return Float.valueOf(df.format(orderTotalValue));
	}
}
