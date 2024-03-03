


import java.util.Scanner;

public class AtmInterface {
    private int balance;
    private final String userID;
    private final String pin;
    private final Scanner scanner;

    public AtmInterface() {
        balance = 0;
        userID = "user123";
        pin = "1234";
        scanner = new Scanner(System.in);
    }

    public void authenticateUser() {
        System.out.print("Enter your user ID: ");
        String userIDInput = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pinInput = scanner.nextLine();
        if (userID.equals(userIDInput) && pin.equals(pinInput)) {
            System.out.println("Authentication successful.");
            displayMenu();
        } else {
            System.out.println("Invalid user ID or PIN. Please try again.");
            authenticateUser();
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Exiting ATM interface. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: $");
        int amount = scanner.nextInt();
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Your new balance is: $" + balance);
        }
    }

    public void depositMoney() {
        System.out.print("Enter the amount to deposit: $");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Deposited $" + amount + ". Your new balance is: $" + balance);
    }

    public static void main(String[] args) {
    	AtmInterface atm = new AtmInterface();
        atm.authenticateUser();
    }
}
