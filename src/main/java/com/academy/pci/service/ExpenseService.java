package com.academy.pci.service;

import com.academy.pci._data.model.Expenses;
import com.academy.pci.exception.InvalidAmountException;

public interface ExpenseService {

	Expenses addExpenses(Expenses expense) throws InvalidAmountException;

	
	
}
