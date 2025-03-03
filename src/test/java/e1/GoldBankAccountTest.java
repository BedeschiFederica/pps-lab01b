package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int LESS_THAN_BALANCE_WITHDRAW_AMOUNT = 200;
    private static final int MORE_THAN_BALANCE_WITHDRAW_AMOUNT = 1200;
    private static final int ILLEGAL_WITHDRAW_AMOUNT = 1700;

    private final BankAccountFactory factory = new BankAccountFactory();

    @Override
    @BeforeEach
    void init(){
        this.account = this.factory.createGoldBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(LESS_THAN_BALANCE_WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - LESS_THAN_BALANCE_WITHDRAW_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertDoesNotThrow(() -> this.account.withdraw(MORE_THAN_BALANCE_WITHDRAW_AMOUNT));
    }

    @Test
    public void testCannotWithdrawMoreThanAllowed() {
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(ILLEGAL_WITHDRAW_AMOUNT));
    }
}
