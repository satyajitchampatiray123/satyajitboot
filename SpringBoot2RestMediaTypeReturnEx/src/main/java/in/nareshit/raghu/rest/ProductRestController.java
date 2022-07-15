package in.nareshit.raghu.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Product;
import in.nareshit.raghu.model.StockQuote;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@GetMapping("/msg")
	public String showMsg() {
		return "Hello Data!";
	}
	
	@GetMapping("/one")
	public Product findOne() {
		return new Product(999, "AA", 200.0);
	}
	
	@GetMapping("/all")
	public List<Product> findAll() {
		return Arrays.asList(
				new Product(101, "AA", 200.0),
				new Product(102, "AB", 300.0),
				new Product(103, "BA", 400.0),
				new Product(104, "CC", 500.0)
				);
	}
	
	@GetMapping("/quote")
	public StockQuote getQuote() {
		return new StockQuote(
				"TEST", "NIT", new Product(104, "CC", 500.0));
	}
	
}
