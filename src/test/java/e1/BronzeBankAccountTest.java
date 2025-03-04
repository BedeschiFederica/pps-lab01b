package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int FEE = 1;

    private final BankAccountFactory factory = new BankAccountFactory();

    @Override
    @BeforeEach
    void init() {
        this.account = this.factory.createBronzeBankAccount();
    }

    @Test
    public void testCanWithdrawSmallAmount() {
        final int smallWithdrawAmount = 50;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(smallWithdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - smallWithdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawLargeAmount() {
        final int largeWithdrawAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(largeWithdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - largeWithdrawAmount - FEE, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        final int illegalWithdrawAmount = 1200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(illegalWithdrawAmount));
    }

}
