package com.intern.service.impl;

import com.intern.service.*;
import com.intern.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.*;

@Service
@Transactional
public class ExpendTypeServiceImpl implements ExpendTypeService {

	@Autowired
	private ExpendTypeDao dao;
	
	@Override
	public List<ExpendType> findExpendTypeByOwner(String owner) {
		return dao.getExpendTypeByOwner(owner);
	}

	@Override
	public List<ExpendType> findExpendTypeLikeName(String owner, String name) {
		return dao.getExpendTypeLikeName(owner, name);
	}
	
}
