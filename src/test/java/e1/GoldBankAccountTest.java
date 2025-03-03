package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends CoreBankAccountTest {

    private final BankAccountFactory factory = new BankAccountFactory();

    @Override
    @BeforeEach
    void init(){
        this.account = this.factory.createGoldBankAccount();
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Test
    public void testCanWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertDoesNotThrow(() -> this.account.withdraw(1200));
    }

}
