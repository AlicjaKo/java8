package myapp;

import java.util.HashMap;
import java.util.Map;

public class SimpleBank {
    private Map<String, Account> accounts;

    public SimpleBank() {
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        if (accounts.containsKey(account.getAccountNumber())) {
            throw new IllegalArgumentException("The account already exists.");
        }
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        if (!accounts.containsKey(toAccountNumber) || !accounts.containsKey(fromAccountNumber)) {
            throw new IllegalArgumentException("Account not found.");
        }     
        else if (accounts.get(fromAccountNumber).getBalance() - amount < 0 ) {
            throw new IllegalArgumentException("Not enough funds.");
        }
        accounts.get(fromAccountNumber).withdraw(amount); //take money from account
        accounts.get(toAccountNumber).deposit(amount); //put money in account

    }
}
