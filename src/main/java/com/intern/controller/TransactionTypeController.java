package com.intern.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intern.model.TransactionType;
import com.intern.req.TransactionTypeReq;
import com.intern.rsp.SingleRes;
import com.intern.service.TransactionTypeService;

@RestController
@RequestMapping("/transaction_type")
public class TransactionTypeController {

	// region -- Fields --

	@Autowired
	private TransactionTypeService ser;

	// end

	// region -- Methods --

	@PostMapping("/create")
	public ResponseEntity<?> createTransactionType(@RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		String idParent = req.getIdParent();
		String name = req.getName();
		String note = req.getNote();
		String owner = req.getOwner();
		String type = req.getType();
		TransactionType transactionType = new TransactionType();
		transactionType.setIdParent(idParent);
		transactionType.setName(name);
		transactionType.setNote(note);
		transactionType.setOwner(owner);
		transactionType.setType(type);

		ser.save(transactionType);

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTransactionType(@PathVariable("id") String id) {
		SingleRes rsp = new SingleRes();

		TransactionType result = ser.delete(id);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Transaction Type doesn't exists.");
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateTransactionType(@PathVariable("id") String id,
			@RequestBody TransactionType newTransactionType) {
		SingleRes rsp = new SingleRes();

		newTransactionType.setId(id);
		TransactionType result = ser.update(newTransactionType);
		if (result != null) {
			rsp.setCallStatus("Fail");
			rsp.setMessage("Transaction Type doesn't exists.");
		}

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> getTransactionType(@RequestBody TransactionTypeReq req) {
		SingleRes rsp = new SingleRes();

		String name = req.getName() == null || req.getName().isEmpty() ? "" : req.getName();
		String owner = req.getOwner() == null || req.getOwner().isEmpty() ? "" : req.getOwner();
		List<TransactionType> lst = ser.findTransactionTypeLikeName(owner, name);
		rsp.setResult(lst);

		return new ResponseEntity<>(rsp, HttpStatus.OK);
	}

	// end
}