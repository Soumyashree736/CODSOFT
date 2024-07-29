import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("ATM Interface");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: Rs" + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: Rs");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: Rs" + account.getBalance());
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: Rs");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: Rs" + account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amount. Withdrawal failed.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100000);
        ATM atm = new ATM(account);
        atm.start();
    }
}