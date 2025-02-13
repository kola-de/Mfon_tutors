package com.academy.pci._data.repository;

import java.util.ArrayList;
import java.util.List;

import com.academy.pci._data.model.Expenses;

public class ExpenseRepositoryImpl implements ExpenseRepository{

	private final List<Expenses> expensesList = new ArrayList<>();

	@Override
	public Expenses save(Expenses expenses) {
		
		if (expenses == null) {
		throw new RuntimeException("Expenses cannot be null");
		}
		
		expensesList.add(expenses);
		return expenses;
	}

	@Override
	public void delete(Expenses expenses) {
		if (expenses == null) {
			throw new RuntimeException("Expenses cannot be null");
		}
		
		expensesList.remove(expenses);
		
	}

	@Override
	public Expenses findById(int id) {
		for(Expenses expenses : expensesList ) {
			
			if(expenses.getId() == id) {
				return expenses;
			}
		}
	
		return null;
	}

	@Override
	public List<Expenses> findAll() {
		
		return new ArrayList<>(expensesList);
	}


	
}
