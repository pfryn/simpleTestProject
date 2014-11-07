package pl.shop;

import java.io.StringWriter;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ShopUtils {

	private static JAXBContext jc;

	static {
		try {
			jc = JAXBContext.newInstance(ProductsMap.class);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	private static Marshaller getMarshaller() {
		try {
			Marshaller marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-16");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			return marshaller;
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

		try {
			ProductsMap p = new ProductsMap();
			p.getOrders().put(1L, new Order(123L, BigDecimal.ONE));
			p.getOrders().put(2L, new Order(15L, BigDecimal.TEN));

			StringWriter sw = new StringWriter();
			getMarshaller().marshal(p, sw);
			System.out.println(sw.toString());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
