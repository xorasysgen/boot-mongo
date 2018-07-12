package boot.backend.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import boot.backend.mongo.dto.Users;
import boot.backend.mongo.service.LoginUserDetailsService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;
	
	
	public LoginUserDetailsService getLoginUserDetailsService() {
		return loginUserDetailsService;
	}


	public void setLoginUserDetailsService(LoginUserDetailsService loginUserDetailsService) {
		this.loginUserDetailsService = loginUserDetailsService;
	}


	@PostMapping("/create")
	@ResponseBody
	public Users create(@RequestBody Users users) {
		System.out.println(users);
		if(users!=null) {
		return loginUserDetailsService.createUser(users);
		}
		else
			return null;
		
	}
	
	
	@GetMapping("/get")
	@ResponseBody
	public List<Users> getAllPerson() {
		return loginUserDetailsService.findAllUsers();
		
	}

}

