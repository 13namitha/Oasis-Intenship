import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


   
class User {
    private String userId;
    private String userPin;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public User(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String UserId() {
        return userId;
    }

    public String UserPin() {
        return userPin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addToTransactionHistory(String transaction) {
        transactionHistory.add(transaction);
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}

// ATM class
class ATM {
    private User user;
    private Scanner scanner;

    // Constructor
    public ATM(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
    }

    // Main menu
    public void Menu() {
        boolean quit = false;
        while (!quit) {
            System.out.println("\nATM Menu");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    // Method to show transaction history
    private void showTransactionHistory() {
        System.out.println("\nTransaction History");
        List<String> transactions = user.getTransactionHistory();
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    // Method to withdraw money
    private void withdraw() {
        System.out.print("\nEnter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount <= 0) {
            System.out.println("Invalid amount! Please try again.");
            return;
        }

        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance! Cannot withdraw.");
            return;
        }

        user.setBalance(user.getBalance() - amount);
        user.addToTransactionHistory("Withdraw: -" + amount);
        System.out.println("Withdrawn " + amount + " successfully.");
        System.out.println("Remaining Balance: " + user.getBalance());
    }

    // Method to deposit money
    private void deposit() {
        System.out.print("\nEnter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount <= 0) {
            System.out.println("Invalid amount! Please try again.");
            return;
        }

        user.setBalance(user.getBalance() + amount);
        user.addToTransactionHistory("Deposit: +" + amount);
        System.out.println("Deposited " + amount + " successfully.");
        System.out.println("Remaining Balance: " + user.getBalance());
    }

    // Method to transfer money
    private void transfer() {
        System.out.print("\nEnter the recipient's user ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        if (amount <= 0) {
            System.out.println("Invalid amount! Please try again.");
            return;
        }

        if (amount > user.getBalance()) {
            System.out.println("Insufficient balance! Cannot transfer.");
            return;
        }

        // Implementation for transferring money from the user's account to another user's account
        // Update the balances and transaction history accordingly
        user.setBalance(user.getBalance() - amount);
        user.addToTransactionHistory("Transfer to " + recipientId + ": -" + amount);

        System.out.println("Transferred " + amount + " to user ID: " + recipientId + " successfully.");
        System.out.println("Remaining Balance: " + user.getBalance());
    }
}

// Main class
public class Task3_ATM_Interface {
    public static void main(String[] args) {
        // Create a user object with a sample user
        User user = new User("123456", "1234", 0.0);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your user PIN: ");
        String userPin = scanner.nextLine();

        if (userId.equals(user.UserId()) && userPin.equals(user.UserPin())) {
            // Authentication successful
            ATM atm = new ATM(user);
            atm.Menu();
        } else {
            System.out.println("Authentication failed! Invalid user ID or PIN.");
        }

        scanner.close();
    }
}
