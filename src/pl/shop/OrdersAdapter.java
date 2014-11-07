package pl.shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class OrdersAdapter extends XmlAdapter<OrderType, Map<Long, Order>> {

	@Override
	public Map<Long, Order> unmarshal(OrderType v) throws Exception {
		Map<Long, Order> hashMap = new HashMap<Long, Order>();
		for (OrderEntryType myEntryType : v.order) {
			hashMap.put(myEntryType.orderId, myEntryType.value);
		}
		return hashMap;
	}

	@Override
	public OrderType marshal(Map<Long, Order> map) throws Exception {
		OrderType ordType = new OrderType();
		for (Entry<Long, Order> entry : map.entrySet()) {
			OrderEntryType ordEntryType =
					new OrderEntryType();
			ordEntryType.orderId = entry.getKey();
			ordEntryType.value = entry.getValue();
			ordType.order.add(ordEntryType);
		}
		return ordType;
	}

}
