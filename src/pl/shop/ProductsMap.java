package pl.shop;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsMap {

	@XmlJavaTypeAdapter(OrdersAdapter.class)
	private Map<Long, Order> orders = new LinkedHashMap<Long, Order>();

	public Map<Long, Order> getOrders() {
		return orders;
	}

	public void setOrders(Map<Long, Order> orders) {
		this.orders = orders;
	}

}
