package e1;

public class DecoratorBankAccount implements BankAccount {

    protected final BankAccount base;

    public DecoratorBankAccount(final BankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return this.base.getBalance();
    }

    public void deposit(final int amount) {
        this.base.deposit(amount);
    }

    public void withdraw(final int amount) {
        this.base.withdraw(amount);
    }
}
