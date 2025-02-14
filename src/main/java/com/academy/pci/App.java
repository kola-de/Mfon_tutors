package com.academy.pci;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.academy.pci._data.model.Expenses;
import com.academy.pci.exception.InvalidAmountException;
import com.academy.pci.service.*;

public class App {

	private static final Scanner scanner = new Scanner(System.in);
	private static final ExpenseService expenseService = new ExpenseServiceImpl();

	public static void main(String[] args) throws InvalidAmountException {
//        System.out.println( "Hello World!" );
		displayMenu();
	}

	public static void displayMenu() throws InvalidAmountException {

		System.out.println("Welcome to Expense Tracker\n" + "Please choose an option:\n" + "1. Generate Report\n"
				+ "2. View Expenses\n" + "3. Add Expenses\n" + "4. Calculate Expenses\n" + "5. Exit");

		int menuOptions = scanner.nextInt();
		switch (menuOptions) {
		case 1:
			genReport();
			break;

		case 2:
			viewExpenses();
			break;

		case 3:
			addExpenses();
			break;

		case 4:
			calcExpenses();
			break;

		case 5:
			System.out.println("Thank you for using Kola Expense Tracker!");
			System.exit(0);

		default:

			System.out.println("Invalid Options: Check the options and try again");

			displayMenu();
		}

	}

	private static void calcExpenses() {
		System.out.println("Calculate expenses not implemented yet...");

	}

	private static void addExpenses() throws InvalidAmountException {
		System.out.println("Follow the next steps to add expenses");

		System.out.println("Enter expense amount:");
		int expenseAmount = scanner.nextInt();

		System.out.println("Enter expense description:");
		String expenseDescription = scanner.next();

		System.out.println("Enter expense category:");
		String expenseCategory = scanner.next();

		LocalDateTime createdAt = LocalDateTime.now();

		Expenses expense = new Expenses(1, expenseAmount, expenseDescription, expenseCategory, createdAt);
		expenseService.addExpenses(expense);

		System.out.println("Expenses added successfully! (" + createdAt + ")");
		System.out.println("Do you want to add more expenses? Type [Yes] or [No]:");
		
		String userInput = scanner.next();

		while (true) {
            System.out.println("Do you want to add more expenses? Type [Yes] or [No]:");
            userInput = scanner.next();

            if (userInput.equalsIgnoreCase("Yes")) {
                addExpenses(); // Call the method to add expenses
            } else if (userInput.equalsIgnoreCase("No")) {
                System.out.println("Thank you for using ...");
                break; // Exit the loop when the user types "No"
            } else {
                System.out.println("This is an invalid option. Type [Yes] or [No].");
            }
        }
		}

	

	private static void viewExpenses() {
		System.out.println("View expenses not implemented yet...");

	}

	private static void genReport() {
		System.out.println("generate report not implemented yet...");

	}

}
