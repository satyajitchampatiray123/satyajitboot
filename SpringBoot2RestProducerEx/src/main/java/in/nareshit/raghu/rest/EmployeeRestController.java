package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@GetMapping("/msg/{id}")
	public ResponseEntity<String> showMsg(
			@PathVariable Integer id
			) {
		//return new ResponseEntity<String>("HELLO",HttpStatus.OK);
		return ResponseEntity.ok("HELLO FROM GET => " +id);
	}
	
	@GetMapping("/findOne")
	public ResponseEntity<Employee> showEmployee() {
		return ResponseEntity.ok(new Employee(101,"AA",200.0));
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> saveEmployee(
			@RequestBody Employee employee
			) 
	{
		return ResponseEntity.ok("DATA AT PRODUCER==>"+employee);
		
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteEmployee(
			@PathVariable Integer id
			) 
	{
		return ResponseEntity.ok("Employee deleted!"+id);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyEmployee(
			@RequestBody Employee employee
			) 
	{
		return ResponseEntity.ok("PRODUCER UPDATED==>"+employee);
		
	}
	
}
