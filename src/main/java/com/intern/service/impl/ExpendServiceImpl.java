package com.intern.service.impl;

import com.intern.model.*;
import com.intern.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intern.dao.*;

@Service
@Transactional
public class ExpendServiceImpl implements ExpendService {

	@Autowired
	private ExpendDao dao;

	@Override
	public List<Expend> findExpendByOwner(String owner) {
		return dao.getExpendByOwner(owner);
	}

	@Override
	public List<Expend> getExpendByExpendType(String expendType) {
		return dao.getExpendByExpendType(expendType);
	}

}
