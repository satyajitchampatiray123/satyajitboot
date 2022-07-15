package in.nareshit.raghu.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@PostMapping("/save")
	public ResponseEntity<String> createEmployee() {
		return new ResponseEntity<String>("CREATED!", HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<String> fetchEmployee() {
		return new ResponseEntity<String>("FECTHING!", HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> updateEmployee() {
		return new ResponseEntity<String>("UPDATED!", HttpStatus.OK);
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteEmployee() {
		return new ResponseEntity<String>("REMOVED!", HttpStatus.OK);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> updateEmployeeEmail() {
		return new ResponseEntity<String>("UPDATED-PATCH!", HttpStatus.OK);
	}
}
