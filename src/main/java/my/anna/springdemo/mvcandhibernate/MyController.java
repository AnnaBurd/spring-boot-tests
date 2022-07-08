package my.anna.springdemo.mvcandhibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import my.anna.springdemo.mvcandhibernate.entities.Emp;
import my.anna.springdemo.mvcandhibernate.entities.EmpDAO;

@Controller
@RequestMapping("/myEmpApp/")
public class MyController {

	@Autowired
	private MyEmpService myEmpService;

	@RequestMapping("/")
	public String showAllEmp(Model model) {

		List<Emp> allEmpInDatabase = myEmpService.getAllEmployees();

		model.addAttribute("allEmpAttr", allEmpInDatabase); // Add emp info to view

		return "all-emp-view";
	}

	@RequestMapping("/addNewEmployee")
	public String addNewEmp(Model model) {

		Emp newEmp = new Emp();

		model.addAttribute("newEmpAttr", newEmp);

		return "emp-details";

	}
	
	@RequestMapping("/saveNewEmployee")
	public String saveNewEmp(@ModelAttribute("newEmpAttr") Emp newEmp) {
		

		myEmpService.saveEmployee(newEmp);
		
	
		
		return "redirect:/myEmpApp/";
	}

}
