package com.intern.service;

import java.util.List;

import com.intern.model.Expend;

public interface ExpendService {
	public List<Expend> findExpendByOwner(String owner);

	public List<Expend> getExpendByExpendType(String expendType);
}
