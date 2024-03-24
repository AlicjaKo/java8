package myapp;

import javax.imageio.IIOException;

public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The value cannot be negative.");
        }
        balance+=amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("The value cannot be negative.");
        }
        if (balance-amount >= 0) {
            balance -= amount;
        }
        else {
            throw new IllegalArgumentException("Insufficient amount of money.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
