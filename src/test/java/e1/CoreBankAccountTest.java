package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int NEGATIVE_AMOUNT = -100;

    protected BankAccount account;

    @BeforeEach
    void init(){
        this.account = new CoreBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCantDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> this.account.deposit(NEGATIVE_AMOUNT));
    }

    @Test
    public void testCantWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> this.account.deposit(NEGATIVE_AMOUNT));
    }
}
