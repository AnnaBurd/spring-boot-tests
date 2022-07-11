package my.anna.springdemo.mvcandhibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		

		System.out.println("Saving employee    :" + newEmp+ " " + newEmp.getId());
		
		
		// save or update hibernate method helps underneath
		myEmpService.saveEmployee(newEmp);
		
	
		
		return "redirect:/myEmpApp/";
	}
	
	@RequestMapping("/updateDetailsEmployee")
	public String updateEmp(@RequestParam("empID") int id, Model model) {
		
		System.out.println("Update Details called");
		
		Emp currEmp = myEmpService.getEmployee(id);
		
		model.addAttribute("newEmpAttr", currEmp);
		
		return "emp-details";
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmp(@RequestParam("empID") int id) {
		
		System.out.println("Delete Details called");
		
		myEmpService.deleteEmployee(id);
		
		return "redirect:/myEmpApp/";		
	}

}
