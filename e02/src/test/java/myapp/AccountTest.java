package myapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("12345");
    }

    @Test
    void depositValidAmountIncreasesBalance() {
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawValidAmountDecreasesBalance() {
        account.deposit(200);
        account.withdraw(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void depositInvalidAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50));
    }

    @Test
    void withdrawInvalidAmountThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void withdrawAmountExceedingBalanceThrowsException() {
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }

    @Test
    void getBalanceAfterSeveralOperations() {
        account.deposit(500);
        account.withdraw(200);
        account.deposit(100);
        assertEquals(400, account.getBalance());
    }

    @Test
    void getAccountNumber() {
        assertEquals("12345", account.getAccountNumber());
    }
}

