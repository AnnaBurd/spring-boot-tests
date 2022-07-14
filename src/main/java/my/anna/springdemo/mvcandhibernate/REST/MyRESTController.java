package my.anna.springdemo.mvcandhibernate.REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	


}
