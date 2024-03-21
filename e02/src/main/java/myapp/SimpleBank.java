package myapp;

import java.util.HashMap;
import java.util.Map;

public class SimpleBank {
    private Map<String, Account> accounts;

    public SimpleBank() {
    }

    public void addAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account getAccount(String accountNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
