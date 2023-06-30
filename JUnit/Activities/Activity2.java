package activities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Activity2 {
    @Test
    public void notEnoughFunds(){
        BankAccount acnt = new BankAccount(10);
        Assertions.assertThrows(NotEnoughFundsException.class, () -> acnt.withdraw(11));
    }

    @Test
    public void enoughFunds(){
        BankAccount acnt = new BankAccount(100);
        Assertions.assertDoesNotThrow(() -> acnt.withdraw(100));
    }
}
