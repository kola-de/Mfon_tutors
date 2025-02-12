package com.academy.pci._data.repository;

import com.academy.pci._data.model.Expenses;

public interface ExpenseRepository {
		//create methods
		Expenses save(Expenses expenses);
		
		void delete(Expenses expenses);
		
		Expenses findById(int id);
}
