package com.academy.pci.service;

import com.academy.pci._data.repository.ExpenseRepository;
import com.academy.pci._data.repository.ExpenseRepositoryImpl;
import com.academy.pci.exception.InvalidAmountException;

import java.util.List;

import com.academy.pci._data.model.Expenses;

public class ExpenseServiceImpl implements ExpenseService {

	private final ExpenseRepository expenseRepository = new ExpenseRepositoryImpl();
	
	
	private void validateExpenseAmount(int amount) throws InvalidAmountException {//helper method

		if (amount <= 0) throw new InvalidAmountException("Invalid amount");
	
	}
	
	@Override
	public Expenses addExpenses(Expenses expense) throws InvalidAmountException {
		
		
		validateExpenseAmount(expense.getAmount());
		expense.setAmount(expense.getAmount());
		expense.setCategory(expense.getCategory());
		expense.setDescription(expense.getDescription());
		expense.setCreatedAt(expense.getcreatedAt());
		
		
		
		return expenseRepository.save(expense);
	}

	@Override
	public int calculateTotalExpense() {
		int totalExpense = 0;
		
		for (Expenses expenses : expenseRepository.findAll()) {
			
			totalExpense += expenses.getAmount();
		}
		
		return totalExpense;
	}

	@Override
	public void deleteExpenses(Expenses delExpense) {

		expenseRepository.delete(delExpense);
		
	}

	@Override
	public List<Expenses> viewAll() {
		
		
		return expenseRepository.findAll();
	}

	

	
	
}

