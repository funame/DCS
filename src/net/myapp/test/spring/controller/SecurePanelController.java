package net.myapp.test.spring.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
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
import net.myapp.dao.SecureUserDAOImpl;
import net.myapp.dao.model.SecureUser;
import net.myapp.dao.model.SecureUserEnum;
import net.myapp.dao.model.UserCard;
import net.myapp.exception.user.UserNotFoundException;
import net.myapp.hbr.dao.UserDAOImpl;
import net.myapp.helper.CommonUtil;
import net.myapp.helper.SecureUserUtil;
import net.myapp.helper.secure.Utils;

@Controller

public class SecurePanelController {
	@Autowired
	private MessageSource messageSource;

	@Autowired(required = true)
	@Qualifier(value = "secureUserDAO")
	private SecureUserDAO secureUserDAO;

	@Autowired(required = true)
	@Qualifier(value = "userDAO")
	private UserDAOImpl userDAOImpl;

	//// normal page passing to default/jsp folder page inside of main.jsp
	@RequestMapping(value = "panel/login", method = RequestMethod.GET)
	public String printHello(@RequestParam(defaultValue = "null") String login,
			@RequestParam(defaultValue = "null") String pass) {

		System.out.println(login);
		if (!CommonUtil.isNullOrEmpty(login)) {
			Log.debug("login : " + login);
			SecureUser secureUser;
			try {
				secureUser = secureUserDAO.getSecureUser(login);

				System.out.println(Utils.getMD5(pass));
				if (secureUser.getPass().equals(Utils.getMD5(pass))) {
					Log.debug("succesfully logined ");
					WebAuthHelper.setAuthenticatedSecureUser(secureUser);

				}
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				RequestHelper.setAttribute("ErrorKey", e1.getI18nErrorMessageKey());
				RequestHelper.setAttribute("ErrorArg", e1.getI18nErrorMessageArg());
				System.out.println(e1.getI18nErrorMessageArg());
				e1.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (SecureUserUtil.isAdmin())
			return "redirect:/admin/first";
		else if (SecureUserUtil.isSeller())
			return "redirect:/seller/first";
		return "login";
	}

	@RequestMapping(value = "panel/logout", method = RequestMethod.GET)
	public String printHello1() {
		WebSessionHelper.clearSessionData();
		return "login";
	}
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String printHello4() {
		
		
		for (UserCard userCard : userDAOImpl.getById(1).getUserCardSet()) {

			/*System.out.println("user balance : "+userCard.getBalance());
			System.out.println("seller name : "+userCard.getSeller().getName());
			System.out.println("card code :"+userCard.getCard().getCode());
			System.out.println("card type :"+userCard.getCard().getCardType().getName());
			*/
			
			RequestHelper.setAttribute("UserCard",userCard);
			
			List<Object[]> list=userDAOImpl.getTest(userCard.getId());
			RequestHelper.setAttribute("Report",list);
			
			/*		for (Object[] objects : list) {
				System.out.println(objects[0].toString());
               // System.out.println(objects[1].toString());
			}
	*/	}
		return "test";
	}

}
