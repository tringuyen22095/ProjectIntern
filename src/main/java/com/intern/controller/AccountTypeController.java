package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.AccountType;
import com.intern.rsp.SingleRes;
import com.intern.service.AccountTypeService;

@RestController
@RequestMapping("/transaction")
public class AccountTypeController {

	// region -- Fields --

	@Autowired
	private AccountTypeService ser;

	// end

	// region -- Methods --

	@GetMapping("/")
	public ResponseEntity<?> searchAccountType() {
		SingleRes rsp = new SingleRes();

		try {
			List<AccountType> lstResult = ser.findAccountTypeLikeName("");
			rsp.setResult(lstResult);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> detailAccountType(@PathVariable("id") int id) {
		SingleRes rsp = new SingleRes();

		try {
			AccountType result = ser.findAccountTypeById(id);
			rsp.setResult(result);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}
