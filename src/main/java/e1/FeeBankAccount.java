package e1;

public class FeeBankAccount extends DecoratorBankAccount {

    private final int thresholdAmount;
    private final int fee;

    public FeeBankAccount(final int thresholdAmount, final int fee, final BankAccount base) {
        super(base);
        this.thresholdAmount = thresholdAmount;
        this.fee = fee;
    }

    @Override
    public void withdraw(final int amount) {
        if (amount < this.thresholdAmount) {
            this.base.withdraw(amount);
        } else {
            this.base.withdraw(amount + this.fee);
        }
    }
}
