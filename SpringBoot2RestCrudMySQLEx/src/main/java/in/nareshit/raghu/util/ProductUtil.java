package in.nareshit.raghu.util;

import in.nareshit.raghu.entity.Product;

//Java 8 - interface # static methods
public interface ProductUtil {

	public static void calculate(Product p) {
		
		double cost = p.getProdCost();
		double gst = cost * 20/100.0;
		double disc = cost * 12/100.0;
		
		p.setProdGst(gst);
		p.setProdDisc(disc);		
	}

}
