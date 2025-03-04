package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    private static final int DEPOSIT_AMOUNT = 1000;
    private static final int SMALL_WITHDRAW_AMOUNT = 50;

    private final BankAccountFactory factory = new BankAccountFactory();

    @Override
    @BeforeEach
    void init(){
        this.account = this.factory.createBronzeBankAccount();
    }

    @Test
    public void testCanWithdrawSmallAmount() {
        this.account.deposit(DEPOSIT_AMOUNT);
        this.account.withdraw(SMALL_WITHDRAW_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT - SMALL_WITHDRAW_AMOUNT, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(DEPOSIT_AMOUNT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
