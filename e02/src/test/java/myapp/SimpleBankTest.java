package myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleBankTest {
    private SimpleBank bank;

    @BeforeEach
    void setUp() {
        bank = new SimpleBank();
    }

    @Test
    void addAccountAndRetrieveSuccessfully() {
        Account account = new Account("12345");
        bank.addAccount(account);
        assertNotNull(bank.getAccount("12345"));
    }

    @Test
    void addDuplicateAccountThrowsException() {
        Account account1 = new Account("12345");
        bank.addAccount(account1);
        Account account2 = new Account("12345");
        assertThrows(IllegalArgumentException.class, () -> bank.addAccount(account2));
    }

    @Test
    void transferFundsBetweenAccountsSuccessfully() {
        Account fromAccount = new Account("12345");
        fromAccount.deposit(500);
        Account toAccount = new Account("67890");
        bank.addAccount(fromAccount);
        bank.addAccount(toAccount);
        bank.transfer("12345", "67890", 200);
        assertEquals(300, fromAccount.getBalance());
        assertEquals(200, toAccount.getBalance());
    }

    @Test
    void transferWithInsufficientFundsThrowsException() {
        Account fromAccount = new Account("12345");
        Account toAccount = new Account("67890");
        bank.addAccount(fromAccount);
        bank.addAccount(toAccount);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("12345", "67890", 200));
    }

    @Test
    void transferToNonExistentAccountThrowsException() {
        Account fromAccount = new Account("12345");
        fromAccount.deposit(300);
        bank.addAccount(fromAccount);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("12345", "unknown", 200));
    }

    @Test
    void transferFromNonExistentAccountThrowsException() {
        Account toAccount = new Account("67890");
        bank.addAccount(toAccount);
        assertThrows(IllegalArgumentException.class, () -> bank.transfer("unknown", "67890", 200));
    }
}

