package com.login.loginpage.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;

@Controller
public class controller {
//@Autowired	
//private UserService userService;

@RequestMapping("/welcome")
public String Welcome(HttpServletRequest request) {
	 request.setAttribute("mode","GET_HOME");
	return "welcomepage";
}
@RequestMapping("/doRegister")
public String Registration(HttpServletRequest request) {
	 request.setAttribute("mode","GET_REGISTER");
	return "welcomepage";
  }

}
