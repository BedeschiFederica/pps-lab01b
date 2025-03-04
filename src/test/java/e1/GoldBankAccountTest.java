package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int MAX_OVERDRAFT = 500;

    private final BankAccountFactory factory = new BankAccountFactory();

    @Override
    @BeforeEach
    void init() {
        this.account = this.factory.createGoldBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        final int lessThanBalanceWithdrawAmount = 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(lessThanBalanceWithdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - lessThanBalanceWithdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable() {
        final int moreThanBalanceWithdrawAmount = DEPOSIT_AMOUNT + 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertDoesNotThrow(() -> this.account.withdraw(moreThanBalanceWithdrawAmount));
    }

    @Test
    public void testCannotWithdrawMoreThanAllowed() {
        final int illegalWithdrawAmount = DEPOSIT_AMOUNT + MAX_OVERDRAFT + 200;
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(illegalWithdrawAmount));
    }
}
