package e1;

public class ConditionalFeeBankAccount extends DecoratorBankAccount {

    private static final int THRESHOLD_AMOUNT = 100;
    private static final int FEE = 1;

    public ConditionalFeeBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(final int amount) {
        if (amount < THRESHOLD_AMOUNT) {
            this.base.withdraw(amount);
        } else {
            this.base.withdraw(amount + FEE);
        }
    }
}
