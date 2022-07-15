package my.anna.springdemo.mvcandhibernate.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.anna.springdemo.mvcandhibernate.MyEmpService;
import my.anna.springdemo.mvcandhibernate.entities.Emp;

@RestController
@RequestMapping("/api")
public class MyRESTController {
	
	@Autowired
	private MyEmpService empService;
	
	@GetMapping("/employees")
	public List<Emp> showAllEmployees(){
		
		System.out.println("REST API GET CALL");
		
		List<Emp> employees = empService.getAllEmployees();
		return employees;
	}
	
	@GetMapping("/employees/{id}") // id - Path variable 
	public Emp getEmployee(@PathVariable int id) {
		
		Emp emp = empService.getEmployee(id);
		
		if(emp==null) {
			throw new NoSuchEmpException("No EMP with id= "+id);
		}
		
		return emp;
	}
	
	@ExceptionHandler
	public ResponseEntity<EmpIncorrectID> handleException(NoSuchEmpException e){
		EmpIncorrectID message = new EmpIncorrectID();
		message.setInfo(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EmpIncorrectID> handleException(Exception e){
		EmpIncorrectID message = new EmpIncorrectID();
		message.setInfo(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}


}
