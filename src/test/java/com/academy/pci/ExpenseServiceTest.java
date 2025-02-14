package com.academy.pci;


import static org.junit.jupiter.api.Assertions.assertEquals;
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
		expense.setCategory("Rice");
		expense.setDescription("Dinner with Valentine");
		expense.setCreatedAt(LocalDateTime.now());
		
		Expenses expectedResult = expenseService.addExpenses(expense);
		
		assertNotNull(expectedResult);
		
	}
	
	@Test
	public void testThatCanCalculateTotalExpenses() throws InvalidAmountException {
		
		Expenses calcExpense = new Expenses();
		
		calcExpense.setAmount(2500);
		calcExpense.setCategory("Rice");
		calcExpense.setDescription("Dinner with Valentine");
		calcExpense.setCreatedAt(LocalDateTime.now());
		
		expenseService.addExpenses(calcExpense);
		
		
		Expenses calcExpense1 = new Expenses();
		
		calcExpense1.setAmount(2500);
		calcExpense1.setCategory("Rice");
		calcExpense1.setDescription("Dinner with Valentine");
		calcExpense1.setCreatedAt(LocalDateTime.now());
		
		expenseService.addExpenses(calcExpense1);
		
		int totalExpense = expenseService.calculateTotalExpense();
		
		assertEquals(5000, totalExpense);
	}
	
	
	@Test
	public void testThatCanDeleteExpenses() {
		
Expenses delExpense = new Expenses();
		
		delExpense.setId(delExpense.getId());
		expenseService.deleteExpenses(delExpense);
		
		assertNotNull(delExpense);
		
		
	}
	
	
	
}
