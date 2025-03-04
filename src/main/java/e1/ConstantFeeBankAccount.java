package e1;

public class ConstantFeeBankAccount extends DecoratorBankAccount {

    private final int fee;

    public ConstantFeeBankAccount(final int fee, BankAccount base) {
        super(base);
        this.fee = fee;
    }

    @Override
    public void withdraw(final int amount) {
        this.base.withdraw(amount + this.fee);
    }
}
