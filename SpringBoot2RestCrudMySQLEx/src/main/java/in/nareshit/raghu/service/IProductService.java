package in.nareshit.raghu.service;

import java.util.List;

import in.nareshit.raghu.entity.Product;

public interface IProductService {

	Integer saveProduct(Product p);
	List<Product> getAllProducts();
	Product getOneProduct(Integer id);
	void deleteProduct(Integer id);
	void updateProduct(Product p);
	
	boolean updateCodeById(String code,Integer id);
}
