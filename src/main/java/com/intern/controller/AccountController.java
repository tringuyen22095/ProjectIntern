package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.Account;
import com.intern.req.AccountReq;
import com.intern.req.SearchReq;
import com.intern.rsp.SingleRes;
import com.intern.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	// region -- Fields --

	@Autowired
	private AccountService ser;

	// end

	// region -- Methods --

	@PostMapping("/")
	public ResponseEntity<?> getAllAccountOfOwner(@RequestBody SearchReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String name = req.getSearchString();
			String owner = req.getOwner();
			List<Account> result = ser.findAccountLikeName(name, owner);
			rsp.setResult(result);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getDetailAccount(@PathVariable("id") int id) {
		SingleRes rsp = new SingleRes();

		try {
			Account result = ser.findAccountById(id);
			if (result != null) {
				rsp.setResult(result);
			} else {
				rsp.setCallStatus("Fail");
				rsp.setMessage("Account doesn't exists.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@RequestBody AccountReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String name = req.getName();
			String owner = req.getOwner();
			String accountType = req.getAccountType();
			String note = req.getNote();
			double ini = req.getIni();
			double rmn = req.getRmn();
			Account newAccount = new Account();
			newAccount.setAccountType(accountType);
			newAccount.setName(name);
			newAccount.setNote(note);
			newAccount.setIni(ini);
			newAccount.setRmn(rmn);
			newAccount.setOwner(owner);
			ser.save(newAccount);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable("id") int id, @RequestBody AccountReq req) {
		SingleRes rsp = new SingleRes();

		try {
			String name = req.getName();
			String owner = req.getOwner();
			String accountType = req.getAccountType();
			String note = req.getNote();
			double ini = req.getIni();
			double rmn = req.getRmn();
			Account newAccount = new Account();
			newAccount.setId(id);
			newAccount.setAccountType(accountType);
			newAccount.setName(name);
			newAccount.setNote(note);
			newAccount.setIni(ini);
			newAccount.setRmn(rmn);
			newAccount.setOwner(owner);
			ser.update(newAccount);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable("id") int id) {
		SingleRes rsp = new SingleRes();

		try {
			ser.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			rsp.setCallStatus("Fail");
			rsp.setMessage(e.getMessage());
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}
