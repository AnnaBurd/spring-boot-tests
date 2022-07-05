package my.anna.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerFirstView {
	String message = "Welcome to try3 !";


	@RequestMapping("/")
	public String showMessage() {
		System.out.println("in controller");

		return "first-view";

	}

}
