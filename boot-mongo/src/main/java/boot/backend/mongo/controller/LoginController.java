package boot.backend.mongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	//@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("errorMsg", "Invalid Username and Password!");

		if (logout != null)
			model.addAttribute("msg", "You have been logged out successfully.");

		return "login";
	}
	

}
