package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.intern.model.*;
import com.intern.req.SearchTransactionReq;
import com.intern.rsp.SingleRes;
import com.intern.service.*;

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
	public ResponseEntity<?> detailAccountType(@PathVariable("id") String id) {
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
