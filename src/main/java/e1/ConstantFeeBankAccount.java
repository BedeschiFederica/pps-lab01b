package e1;

public class ConstantFeeBankAccount extends DecoratorBankAccount {

    private static final int FEE = 1;

    public ConstantFeeBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(final int amount) {
        this.base.withdraw(amount + FEE);
    }
}
