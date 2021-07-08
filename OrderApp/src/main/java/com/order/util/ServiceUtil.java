package com.order.util;

import java.text.DecimalFormat;
import java.util.List;

import com.order.model.OrderLineitem;

public class ServiceUtil {
	private static final String FLOATING_TWO_DECIMAL_FORMAT = "#.##";

	public static float getFormattedFloatingValue(float orderTotalValue) {
		DecimalFormat df = new DecimalFormat(FLOATING_TWO_DECIMAL_FORMAT);
		return Float.valueOf(df.format(orderTotalValue));
	}

	public static List<OrderLineitem> applyOffer(List<OrderLineitem> orderLineitems) {

		for (OrderLineitem item : orderLineitems) {
			if (item.getOffer() != null) {
				switch (item.getOffer()) {
				case "BOGO":
					item.setQuantity(item.getQuantity() * 2);
					break;
				case "3FOR2":
					int quotient = item.getQuantity() / 2;
					item.setQuantity(item.getQuantity() + quotient);
					break;
				}
			}
		}
		return orderLineitems;
	}
}
