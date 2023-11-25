import java.util.Scanner;

class BankAccount {
    private int balance;

    public static final int INITIAL_BALANCE = 30000;

    public BankAccount(int initialAmount) {
        this.balance = initialAmount;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " Rs was successful. New balance: " + balance + " Rs");
        } else {
            System.out.println("Invalid amount! Please enter a positive number.");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " Rs was successful. New balance: " + balance + " Rs");
        } else {
            System.out.println("Invalid amount! Insufficient balance or negative value entered.");
        }
    }
}

class ATM {

    private BankAccount account;

    public static final String CORRECT_PIN = "1234";

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void display() {
        System.out.println("Select Options");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Leave");
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            display();
            System.out.println("Pick an option");
            option = getIntInput(sc);

            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    int depositAmount = getIntInput(sc);
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    int withdrawAmount = getIntInput(sc);
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance() + " Rs");
                    break;
                case 4:
                    System.out.println("Thanks for working with CODSOFT Bank");
                    break;
                default:
                    System.out.println("Invalid entry!! Enter only the given options");
            }
        } while (option != 4);
        sc.close();
    }

    private int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }
}

public class Task3_AtmInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(BankAccount.INITIAL_BALANCE);
        ATM atm = new ATM(userAccount);

        System.out.println("Welcome to CODSOFT Bank");
        System.out.println("Enter Your PIN:");
        String pin = sc.nextLine();

        if (pin.equals(ATM.CORRECT_PIN)) {
            atm.run();
        } else {
            System.out.println("Wrong PIN. Exiting...");
        }
    }
}
