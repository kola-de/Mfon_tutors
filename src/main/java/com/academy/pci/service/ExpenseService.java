package com.academy.pci.service;

import java.util.List;

import com.academy.pci._data.model.Expenses;
import com.academy.pci.exception.InvalidAmountException;

public interface ExpenseService {

	Expenses addExpenses(Expenses expense) throws InvalidAmountException;

	int calculateTotalExpense();

	void deleteExpenses(Expenses delExpense);
	
	List <Expenses> viewAll();
	
	String generateReport();

}
