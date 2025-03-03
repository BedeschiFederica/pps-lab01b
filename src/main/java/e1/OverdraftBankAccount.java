package e1;

public class OverdraftBankAccount extends DecoratorBankAccount {

    private static final int MAX_OVERDRAFT = 500;

    public OverdraftBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(final int amount) {
        if (this.base.getBalance() < amount - MAX_OVERDRAFT) {
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
