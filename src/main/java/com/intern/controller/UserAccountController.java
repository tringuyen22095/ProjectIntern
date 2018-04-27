package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.config.JwtTokenUtil;
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

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	// end

	// region -- Methods --

	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody UserAccountReq req) {
		SingleRes rsp = new SingleRes();

		// String userName = req.getUserName();
		// String password = req.getPassword();
		//
		// UserAccount userAccountExisted = ser.findUserAccountByUserName(userName);
		// if (userAccountExisted == null) {
		// rsp.setCallStatus("Fail");
		// rsp.setMessage("Wrong user name or password.");
		// } else {
		// if (!userAccountExisted.getPassword().equals(password)) {
		// rsp.setCallStatus("Fail");
		// rsp.setMessage("Wrong user name or password.");
		// }
		// }
		try {
			// Get data
			String userName = req.getUserName();
			String password = req.getPassword();

			// Handle
			UserAccount m = ser.findUserAccountByUserName(userName);
			if (m == null) {
				rsp.setCallStatus("Fail");
				rsp.setMessage("You do not have account created. Please signup and continue!");
			} else {
				UsernamePasswordAuthenticationToken x = new UsernamePasswordAuthenticationToken(userName, password);
				Authentication y = authenticationManager.authenticate(x);
				SecurityContextHolder.getContext().setAuthentication(y);

				List<SimpleGrantedAuthority> z = ser.getAuthorityByUserId();
				String token = jwtTokenUtil.doGenerateToken(m, z);

				// Set data
				rsp.setCallStatus("Success");
				rsp.setResult(token);
			}
		} catch (AuthenticationException e) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Unauthorized / Invalid email or password!");
		} catch (Exception ex) {
			rsp.setCallStatus("Fail");
			rsp.setMessage(ex.getMessage());
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
		newUserAccount.setPassword(bCryptPasswordEncoder.encode(password));
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
