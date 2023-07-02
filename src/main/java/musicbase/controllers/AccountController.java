package musicbase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	@GetMapping("/login")
	public String viewLoginPage() {
		return "/account/login";
	}
	
	@GetMapping("/register")
	public String viewRegisterPage() {
		return "/account/register";
	}
	
	@GetMapping("/login-error.html")
	public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "/account/login";
	}
}
