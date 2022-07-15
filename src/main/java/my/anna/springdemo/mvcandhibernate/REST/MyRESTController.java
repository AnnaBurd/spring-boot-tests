package my.anna.springdemo.mvcandhibernate.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.anna.springdemo.mvcandhibernate.MyEmpService;
import my.anna.springdemo.mvcandhibernate.entities.Emp;
import my.anna.springdemo.mvcandhibernate.exceptionHandlers.NoSuchEmpException;

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
	
	@PostMapping("/employees")
	public Emp addEmployee(@RequestBody Emp emp) {
		
		empService.saveEmployee(emp);
		// Hibernate automatically updates id after save to db
		return emp;		
	}
	
	@PutMapping("/employees")
	public Emp updateEmployee(@RequestBody Emp emp) {
		
		empService.saveEmployee(emp);
		return emp;		
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmp(@PathVariable int id) {
		
		Emp emp = empService.getEmployee(id);
		if (emp == null) {
			
			throw new NoSuchEmpException("There is no emp with id = " + id);
		}
		
		empService.deleteEmployee(id);
		
		
		
		return new String("EMp with id=" + id + " was deleted");
		
	}


}
