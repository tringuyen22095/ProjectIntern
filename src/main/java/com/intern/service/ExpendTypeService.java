package com.intern.service;

import java.util.List;

import com.intern.model.*;

public interface ExpendTypeService {
	public List<ExpendType> findExpendTypeByOwner(String owner);

	public List<ExpendType> findExpendTypeLikeName(String owner, String name);
}
