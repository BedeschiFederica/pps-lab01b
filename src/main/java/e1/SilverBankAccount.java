package e1;

public class SilverBankAccount extends DecoratorBankAccount {

    public SilverBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(final int amount) {
        if (this.base.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + 1);
    }
}
