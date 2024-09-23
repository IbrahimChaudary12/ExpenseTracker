import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    private static ArrayList<Expense> expenses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear the newline

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the Expense Tracker...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
        scanner.close();
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        expenses.add(new Expense(description, amount));
        System.out.println("Expense added.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show.");
        } else {
            System.out.println("\nList of Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    private static void deleteExpense(Scanner scanner) {
        viewExpenses();
        if (!expenses.isEmpty()) {
            System.out.print("Enter the number of the expense to delete: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= expenses.size()) {
                expenses.remove(index - 1);
                System.out.println("Expense deleted.");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }
}
