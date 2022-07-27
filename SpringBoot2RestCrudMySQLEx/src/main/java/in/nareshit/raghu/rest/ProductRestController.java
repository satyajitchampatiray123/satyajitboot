package in.nareshit.raghu.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.entity.Product;
import in.nareshit.raghu.exception.ProductNotFoundException;
import in.nareshit.raghu.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/rest/product")
@Api(description = "TEST PRODUCT OPERATION")
public class ProductRestController {

	@Autowired
	private IProductService service;

	//1. create product
	@PostMapping("/save")
	public ResponseEntity<String> createProduct(
			@RequestBody Product product) 
	{
		Integer id = service.saveProduct(product);
		String body = "Product '"+id+"' created!";

		return new ResponseEntity<String>(
				body,
				HttpStatus.CREATED); //201 new object is created
	}
	
	//2. fetch all products
	@GetMapping("/all")
	@ApiOperation("FETCH ALL ROWS AS LIST")
	public ResponseEntity<List<Product>> fetchAllProducts() {
		List<Product> list = service.getAllProducts();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	
	
	//3. fetch one by id
	@GetMapping("/one/{id}")
	@ApiOperation("FETCH DATA BY ID")
	public ResponseEntity<?> fetchOneProduct(
			@PathVariable Integer id)
	{
		ResponseEntity<?> response = null;
		try {
			Product product = service.getOneProduct(id);
			response = new ResponseEntity<Product>(product,HttpStatus.OK);
			
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			response = new ResponseEntity<String>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	
	//4. remove one by id
	@DeleteMapping("/remove/{id}")
	@ApiIgnore
	public ResponseEntity<String> deleteProduct(
			@PathVariable Integer id) 
	{
		ResponseEntity<String> response = null;
		try {
			service.deleteProduct(id);
			response = new ResponseEntity<String>(
					id +" - Removed", HttpStatus.OK);
			
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			response = new ResponseEntity<String>(
					e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	
	//5. (PUT)update product
	@PutMapping("/modify")
	public ResponseEntity<String> updateProduct(
			@RequestBody Product product) 
	{
		ResponseEntity<String> response = null;
		try {
			service.updateProduct(product);
			response = new ResponseEntity<String>(
					"Updated!!", HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			response = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	//6. (PATCH) partial update
	@PatchMapping("/update/{id}/{code}")
	public ResponseEntity<String> updateProductCode(
			@PathVariable Integer id,
			@PathVariable String code
			) 
	{
		ResponseEntity<String> response = null;
		try {
			service.updateCodeById(code, id);
			response = new ResponseEntity<String>(
					"Code is Updated!", HttpStatus.OK);
			
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
			response = new ResponseEntity<String>(
					e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	
}
