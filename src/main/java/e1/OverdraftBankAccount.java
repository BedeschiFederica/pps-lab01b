package e1;

public class OverdraftBankAccount extends DecoratorBankAccount {

    private final int maxOverdraft;

    public OverdraftBankAccount(final int maxOverdraft, final BankAccount base) {
        super(base);
        this.maxOverdraft = maxOverdraft;
    }

    @Override
    public void withdraw(final int amount) {
        if (this.base.getBalance() < amount - this.maxOverdraft) {
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
