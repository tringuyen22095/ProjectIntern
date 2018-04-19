package com.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.intern.res.*;
import com.intern.req.*;
import com.intern.model.*;
import com.intern.service.*;

@RestController
@RequestMapping("/user_account")
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;

	@PostMapping("/signIn")
	public ResponseEntity<?> SignIn(@RequestBody UserAccountReq req) {
		SingleRes res = new SingleRes();

		String userName = req.getUserName();
		String password = req.getPassword();

		UserAccount userAccountExisted = userAccountService.findUserAccountByUserName(userName);
		if (userAccountExisted == null) {
			res.setCallStatus("Fail");
			res.setMessage("Wrong user name or password.");
		} else {
			if (!userAccountExisted.getPassword().equals(password)) {
				res.setCallStatus("Fail");
				res.setMessage("Wrong user name or password.");
			}
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@PostMapping("/signUp")
	public ResponseEntity<?> SignUp(@RequestBody UserAccountReq req) {
		SingleRes res = new SingleRes();

		String userName = req.getUserName();
		String password = req.getPassword();
		String email = req.getEmail();
		String telephone = req.getTelephone();
		String fullName = req.getFull_name();
		String status = req.getStatus();
		UserAccount newUserAccount = new UserAccount();
		newUserAccount.setEmail(email);
		newUserAccount.setFullName(fullName);
		newUserAccount.setPassword(password);
		newUserAccount.setTelephone(telephone);
		newUserAccount.setUserName(userName);
		newUserAccount.setStatus(status != null ? status : "active");

		String result = userAccountService.save(newUserAccount);
		if (result != null) {
			res.setCallStatus("Fail");
			res.setMessage(result);
		}

		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
