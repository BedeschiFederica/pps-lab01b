package e1;

public class NoOverdraftBankAccount extends DecoratorBankAccount {

    public NoOverdraftBankAccount(BankAccount base) {
        super(base);
    }

    @Override
    public void withdraw(final int amount) {
        if (this.base.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount);
    }
}
