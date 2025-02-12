package com.academy.pci;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.academy.pci._data.enums.Category;
import com.academy.pci._data.model.Expenses;
import com.academy.pci.exception.InvalidAmountException;
import com.academy.pci.service.ExpenseService;
import com.academy.pci.service.ExpenseServiceImpl;

public class ExpenseServiceTest {

	
	private final ExpenseService expenseService = new ExpenseServiceImpl();
	


	@Test
	public void testThatExpensesCanBeAdded() throws InvalidAmountException {
		
		Expenses expense = new Expenses();
		
		expense.setAmount(3000);
		expense.setCategory(Category.FOOD);
		expense.setDescription("Dinner with Valentine");
		expense.setCreatedAt(LocalDateTime.now());
		
		Expenses expectedResult = expenseService.addExpenses(expense);
		
		assertNotNull(expectedResult);
		
	}
	
}
