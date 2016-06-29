package net.myapp.test.spring.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.myapp.common.logging.impl.Log;
import net.myapp.common.web.holders.RequestHelper;
import net.myapp.common.web.holders.WebAuthHelper;
import net.myapp.common.web.holders.WebSessionHelper;
import net.myapp.dao.SecureUserDAO;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.SecureUserEnum;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.helper.CommonUtil;
import net.myapp.helper.SecureUserUtil;
import net.myapp.helper.secure.Utils;

@Controller

public class AdminController {
	@Autowired
	private MessageSource messageSource;

	@Autowired(required = true)
	@Qualifier(value = "secureUserDAO")
	// private SecureUserDAOImpl secureUserDAOImpl;
	private SecureUserDAO secureUserDAO;

	
	
	@RequestMapping(value = "/admin/first", method = RequestMethod.GET)
	public String printHello2(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {
		return "test";
		//new bracnh
	}
	



}
