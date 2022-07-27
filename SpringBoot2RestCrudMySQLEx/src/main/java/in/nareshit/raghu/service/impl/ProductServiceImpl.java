package in.nareshit.raghu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nareshit.raghu.entity.Product;
import in.nareshit.raghu.exception.ProductNotFoundException;
import in.nareshit.raghu.repo.ProductRepository;
import in.nareshit.raghu.service.IProductService;
import in.nareshit.raghu.util.ProductUtil;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;
	//@Autowired
	//private ProductUtil util;
	
	public Integer saveProduct(Product p) {
		ProductUtil.calculate(p);
		return repo.save(p).getProdId();
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getOneProduct(Integer id) {
		/*Optional<Product> opt = repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new ProductNotFoundException(id+ "- not exist");
		}*/
		return repo.findById(id)
				.orElseThrow(()->new ProductNotFoundException(id+ "- not exist"));
	}

	public void deleteProduct(Integer id) {
		//repo.deleteById(id);
		repo.delete(getOneProduct(id));
	}

	public void updateProduct(Product p) {
		if(p.getProdId()!=null && repo.existsById(p.getProdId())) {
			ProductUtil.calculate(p);
			repo.save(p);
		} else {
			throw new ProductNotFoundException(p.getProdId()+ "- not exist");
		}
	}

	@Transactional
	public boolean updateCodeById(String code, Integer id) {
		/*Integer count = repo.updateCodeById(code, id);
		return count >0 ? true : false;*/
		if(id!=null && repo.existsById(id)) {
			return repo.updateCodeById(code, id) > 0 ;
		}else {
			throw new ProductNotFoundException(id+ "- not exist");
		}
	}
	
}
