package com.academy.pci._data.repository;

import java.util.List;

import com.academy.pci._data.model.Expenses;

public interface ExpenseRepository {
		//create methods
		Expenses save(Expenses expenses);
		
		void delete(Expenses expenses);
		
		Expenses findById(int id);
		
		List<Expenses> findAll();
}
