package my.anna.springdemo.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/myApp/")
public class ControllerMVC {
	String message = "Welcome to try3 !";


	@RequestMapping("/")
	public String showMainPage() {
		System.out.println("in controller");

		return "first-view";

	}

	@RequestMapping("/askDetails")
	public String askEmployeeDetails(Model model){	
		System.out.println("asking details");

		// Add empty employee to fill up from form
		model.addAttribute("employeeAttribute", new Employee("name","surname",200,"worker"));

		return "ask-emp-details-view";		
	}

	//	@RequestMapping("/showDetails")
	//	public String showEmployeeDetails() {	
	//		System.out.println("showing details");
	//		return "show-emp-details-view";
	//	}



	//	@RequestMapping("/showDetails")
	//	public String showEmployeeDetails(HttpServletRequest request, Model model) {	
	//		System.out.println("showing details");
	//		String empName = request.getParameter("employeeName");
	//		System.out.println(request);
	//		
	//		empName = "Mr. " + empName;
	//		
	//		model.addAttribute("nameAttr", empName);
	//		
	//		return "show-emp-details-view";
	//	}


	//	@RequestMapping("/showDetails")
	//	public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model) {	
	//		System.out.println("showing details");
	//		
	//		empName = "Mr. " + empName;
	//		
	//		model.addAttribute("nameAttr", empName);
	//		
	//		return "show-emp-details-view";
	//	}

	//	@RequestMapping("/showDetails")
	//	public String showEmployeeDetails(@ModelAttribute("employeeAttribute")Employee emp) {	
	//		System.out.println("showing details");
	//		
	//		System.out.println(emp);
	//		
	//		String name = emp.getName();
	//		emp.setName("Mr " + name);
	//		
	//		// How to guarantee emp is filled with data???
	//		
	//		
	//		return "show-emp-details-view";
	//	}
	//	



	// @Valid for validation of empAttribute in module
	@RequestMapping("/showDetails")	
	public String showEmployeeDetails(@Valid @ModelAttribute("employeeAttribute")Employee emp, 
			BindingResult bindingResult) {	
		System.out.println("showing emp details " + emp);

		
		
		// On errors in data redirect to form page
		if(bindingResult.hasErrors()) {
			System.out.println("Error validation from form data");
			System.out.println(bindingResult);
			return "ask-emp-details-view";
		}

		String name = emp.getName();
		emp.setName("Mr " + name);



		return "show-emp-details-view";
	}

}
