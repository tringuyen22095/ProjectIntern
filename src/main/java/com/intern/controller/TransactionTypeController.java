package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.TransactionExpense;
import com.intern.model.TransactionIncome;
import com.intern.req.TransactionTypeReq;
import com.intern.rsp.SingleRes;
import com.intern.service.TransactionExpenseService;
import com.intern.service.TransactionIncomeService;

@RestController
@RequestMapping("/transaction_type")
public class TransactionTypeController {

	// region -- Fields --

	@Autowired
	private TransactionExpenseService serExpense;
	@Autowired
	private TransactionIncomeService serIncome;

	// end

	// region -- Methods --

	@PostMapping("/expense/create")
	public ResponseEntity<?> createTransactionExpense(@RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		int idParent = req.getIdParent();
		String name = req.getName();
		String note = req.getNote();
		String owner = req.getOwner();
		TransactionExpense transactionExpense = new TransactionExpense();
		transactionExpense.setIdParent(idParent);
		transactionExpense.setName(name);
		transactionExpense.setNote(note);
		transactionExpense.setOwner(owner);

		serExpense.save(transactionExpense);

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@DeleteMapping("/expense/{id}")
	public ResponseEntity<?> deleteTransactionExpense(@PathVariable("id") int id) {
		SingleRes rsp = new SingleRes();

		TransactionExpense result = serExpense.delete(id);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Transaction Type doesn't exists.");
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PutMapping("/expense/{id}")
	public ResponseEntity<?> updateTransactionExpense(@PathVariable("id") int id, @RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		int idParent = req.getIdParent();
		String name = req.getName();
		String note = req.getNote();
		String owner = req.getOwner();
		TransactionExpense newTransactionExpense = new TransactionExpense();
		newTransactionExpense.setId(id);
		newTransactionExpense.setIdParent(idParent);
		newTransactionExpense.setName(name);
		newTransactionExpense.setNote(note);
		newTransactionExpense.setOwner(owner);
		TransactionExpense result = serExpense.update(newTransactionExpense);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Transaction Type doesn't exists.");
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/expense/")
	public ResponseEntity<?> getTransactionExpense(@RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		String name = req.getName() == null || req.getName().isEmpty() ? "" : req.getName();
		String owner = req.getOwner() == null || req.getOwner().isEmpty() ? "" : req.getOwner();
		List<TransactionExpense> lst = serExpense.findTransactionExpenseLikeName(owner, name);
		rsp.setResult(lst);

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/income/create")
	public ResponseEntity<?> createTransactionIncome(@RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		int idParent = req.getIdParent();
		String name = req.getName();
		String note = req.getNote();
		String owner = req.getOwner();
		TransactionIncome transactionIncome = new TransactionIncome();
		transactionIncome.setIdParent(idParent);
		transactionIncome.setName(name);
		transactionIncome.setNote(note);
		transactionIncome.setOwner(owner);

		serIncome.save(transactionIncome);

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@DeleteMapping("/income/{id}")
	public ResponseEntity<?> deleteTransactionIncome(@PathVariable("id") int id) {
		SingleRes rsp = new SingleRes();

		TransactionIncome result = serIncome.delete(id);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Transaction Type doesn't exists.");
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PutMapping("/income/{id}")
	public ResponseEntity<?> updateTransactionIncome(@PathVariable("id") int id, @RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		int idParent = req.getIdParent();
		String name = req.getName();
		String note = req.getNote();
		String owner = req.getOwner();
		TransactionIncome newTransactionIncome = new TransactionIncome();
		newTransactionIncome.setId(id);
		newTransactionIncome.setIdParent(idParent);
		newTransactionIncome.setName(name);
		newTransactionIncome.setNote(note);
		newTransactionIncome.setOwner(owner);
		TransactionIncome result = serIncome.update(newTransactionIncome);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Transaction Type doesn't exists.");
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/income/")
	public ResponseEntity<?> getTransactionIncome(@RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		String name = req.getName() == null || req.getName().isEmpty() ? "" : req.getName();
		String owner = req.getOwner() == null || req.getOwner().isEmpty() ? "" : req.getOwner();
		List<TransactionIncome> lst = serIncome.findTransactionIncomeLikeName(owner, name);
		rsp.setResult(lst);

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}