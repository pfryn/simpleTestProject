package pl.shop;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class OrderEntryType {

	@XmlAttribute
	public Long orderId;

	@XmlElement(name = "")
	public Order value;
}
