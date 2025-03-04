package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends CoreBankAccountTest {

    private final BankAccountFactory factory = new BankAccountFactory();

    @Override
    @BeforeEach
    void init(){
        this.account = this.factory.createBronzeBankAccount();
    }

    @Test
    public void testCanWithdrawSmallAmount() {
        this.account.deposit(1000);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
    }

}
