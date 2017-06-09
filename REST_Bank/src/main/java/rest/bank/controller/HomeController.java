package rest.bank.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
  
@Controller
public class HomeController {

 
	@RequestMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("greeting", "Welcome to REST BANK!!");
		model.addAttribute("tagline", "a convenient service that enables you to receive, "
				+ "view and pay your bills from one centralized place!!");
		
		return "welcome";
	}
 
}
