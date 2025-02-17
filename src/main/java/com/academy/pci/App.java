package com.academy.pci;
import static java.lang.System.exit;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.academy.pci._data.model.Expenses;
import com.academy.pci._data.model.Users;
import com.academy.pci.exception.InvalidAmountException;
import com.academy.pci.service.*;

public class App {

	private static final Scanner scanner = new Scanner(System.in);
	private static final ExpenseService expenseService = new ExpenseServiceImpl();
	private static final UserService userService = new UserServiceImpl();

	public static void main(String[] args) throws InvalidAmountException {
//        System.out.println( "Hello World!" );
		//displayMenu();
		userAuth();
	}

	
	public static void userAuth() throws InvalidAmountException{
        String userOption = 
               "\nWelcome to Expense Tracker Testing System" +
                "\n1 -> Sign up" +
                "\n2 -> Sign in";
        
        
        String userChoice = JOptionPane.showInputDialog(userOption);
        switch (userChoice){
            case "1":
                signUp();
                break;
            case "2":
                signIn();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                userAuth();
                break;
        }
    }    
	
	
	
	
	private static void signUp() throws InvalidAmountException {
		
		String firstName = JOptionPane.showInputDialog("Enter your first name:");

        String lastName = JOptionPane.showInputDialog("Enter your last name:");

        String email = JOptionPane.showInputDialog("Enter your email:");

        String password = JOptionPane.showInputDialog("Enter your password:");

        userService.signUp(new Users(1, firstName, lastName, email, password));
        // userService.createUserAccount(new Users(5, firstName, lastName, password, email));
        
        String confirmPassword = JOptionPane.showInputDialog("Confirm your password:");
	
        if(password.equals(confirmPassword)){
            JOptionPane.showMessageDialog(null, "Account created successfully. Please sign in.");
            signIn();
        } else {
            JOptionPane.showMessageDialog(null,"Passwords do not match. Please try again.");
            signUp();
        }
	}


	private static void signIn() throws InvalidAmountException {

		String email = JOptionPane.showInputDialog("Enter your email:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        userService.logIn(email,  password);
        JOptionPane.showMessageDialog(null,"Welcome " + email);
        displayMenu();
	}

	
	
	

	public static void displayMenu() throws InvalidAmountException {

		String menu = "Welcome to Expense Tracker\n" + "Please choose an option:\n" + "1. Generate Report\n"
				+ "2. View Expenses\n" + "3. Add Expenses\n" + "4. Calculate Expenses\n" + "5. Exit";

		String menuOptions = JOptionPane.showInputDialog(menu);
		switch (menuOptions) {
		case "1":
			genReport();
			break;

		case "2":
			viewExpenses();
			break;

		case "3":
			addExpenses();
			break;

		case "4":
			calcExpenses();
			break;

		case "5":
			JOptionPane.showMessageDialog(null, "Thank you for using Kola Expense Tracker!");
			exit(0);

		default:

			JOptionPane.showMessageDialog(null, "Invalid option, please try again");
			displayMenu();
		}
	}

	
	
	private static void calcExpenses() throws InvalidAmountException {

		int calculatedAmout = expenseService.calculateTotalExpense();
		System.out.println("The total expenses is: " + calculatedAmout + "\n");

		displayMenu();
	}

	
	
	
	private static void addExpenses() throws InvalidAmountException {
        JOptionPane.showMessageDialog(null, "Track your expenses");

        while (true) {
        	String amountInput = JOptionPane.showInputDialog("Enter expense amount: ");
        	

            // Parse the amount and handle potential exceptions
            int amount = 0;
            try {
                amount = Integer.parseInt(amountInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid integer.");
                continue; // Restart the loop for valid inputs
            }
            
            String description = JOptionPane.showInputDialog("Enter expense description: ");
            
            String category = JOptionPane.showInputDialog("Enter expense category: ");

            LocalDateTime dateTime = LocalDateTime.now();
            Expenses expense = new Expenses(5, amount, description, category, dateTime); // consider generating a unique ID
            expenseService.addExpenses(expense);

            JOptionPane.showMessageDialog(null, "Expense added successfully on " + dateTime);

            String answer = JOptionPane.showInputDialog("Do you want to add another expense? (yes/no)");

            if (answer.equalsIgnoreCase("no")) {
                JOptionPane.showMessageDialog(null, "Thank you for using the expense tracker.");
                displayMenu();
                break; // Exit the loop
            } else if (!answer.equalsIgnoreCase("yes")) {
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                // Optionally, you could loop back to ask if they want to add another expense
            }
        }
    }
	
	
	
	private static void addMoreExpenses() throws InvalidAmountException {

	    while (true) {
	        String userInput = scanner.next();

	        if (userInput.equalsIgnoreCase("yes")) {
	            addExpenses();
	        } else if (userInput.equalsIgnoreCase("no")) {
	            System.out.println();
	            displayMenu();
	            break; // Exit the loop
	        } else {
	            System.out.println("This is an invalid option! \nType [Yes] or [No]");
	        }
	    }
		
	}

	
	
	
	private static void viewExpenses() throws InvalidAmountException {

		List<Expenses> expense = expenseService.viewAll();

		System.out.println("\n" + expense.size());

		for (Expenses expenses : expense) {
			System.out.println(
					"Amount: " + expenses.getAmount() + "\nCategory: " + expenses.getCategory() + "\nDescription: "
							+ expenses.getDescription() + "\nCreated at: " + "\n" + expenses.getcreatedAt() + "\n");
		}
		displayMenu();
	}

	
	
	
	private static void genReport() throws InvalidAmountException {
		String expenseReport = expenseService.generateReport();
        JOptionPane.showMessageDialog(null, "Total expenses is : " + expenseReport);
        displayMenu();
		

	}

}
