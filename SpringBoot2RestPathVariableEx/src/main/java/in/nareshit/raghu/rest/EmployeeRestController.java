package in.nareshit.raghu.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@GetMapping("/find/grade/code")
	public String showDataA() 
	{
		return "HELLO :: A " ;
	}

	@GetMapping("/find/grade/{code}")
	public String showDataB(
			@PathVariable String code
			) 
	{
		return "HELLO :: B " + code;
	}
	
	@GetMapping("/find/{grade}/{code}")
	public String showDataC(
			@PathVariable String grade,
			@PathVariable String code
			) 
	{
		return "HELLO :: C " + grade + "-" + code;
	}
}
