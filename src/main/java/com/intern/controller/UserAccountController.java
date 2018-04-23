package com.intern.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.UserAccount;
import com.intern.req.UserAccountReq;
import com.intern.rsp.SingleRes;
import com.intern.service.UserAccountService;

@RestController
@RequestMapping("/user_account")
public class UserAccountController {

	// region -- Fields --

	@Autowired
	private UserAccountService ser;

	// end

	// region -- Methods --

	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody UserAccountReq req) {
		SingleRes rsp = new SingleRes();

		String userName = req.getUserName();
		String password = req.getPassword();

		UserAccount userAccountExisted = ser.findUserAccountByUserName(userName);
		if (userAccountExisted == null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Wrong user name or password.");
		} else {
			if (!userAccountExisted.getPassword().equals(password)) {
				rsp.setCallStatus("Fail");
				rsp.setMessage("Wrong user name or password.");
			}
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@RequestBody UserAccountReq req) {
		SingleRes rsp = new SingleRes();

		String userName = req.getUserName();
		String password = req.getPassword();
		String email = req.getEmail();
		String telephone = req.getTelephone();
		String fullName = req.getFullName();
		UserAccount newUserAccount = new UserAccount();
		newUserAccount.setEmail(email);
		newUserAccount.setFullName(fullName);
		newUserAccount.setPassword(password);
		newUserAccount.setTelephone(telephone);
		newUserAccount.setUserName(userName);

		String result = ser.save(newUserAccount);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage(result);
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}
