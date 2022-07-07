package my.anna.springdemo.mvc;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myApp/")
public class ControllerFirstView {
	String message = "Welcome to try3 !";


	@RequestMapping("/")
	public String showMessage() {
		System.out.println("in controller");

		return "first-view";

	}
	
	@RequestMapping("/askDetails")
	public String askEmployeeDetails(){	
		System.out.println("asking details");
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
	
	
	@RequestMapping("/showDetails")
	public String showEmployeeDetails(@RequestParam("employeeName") String empName, Model model) {	
		System.out.println("showing details");
		
		empName = "Mr. " + empName;
		
		model.addAttribute("nameAttr", empName);
		
		return "show-emp-details-view";
	}
	

}
