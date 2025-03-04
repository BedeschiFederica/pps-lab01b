package e1;

class CoreBankAccount implements BankAccount {

    private int balance = 0;

    public int getBalance() {
        return this.balance;
    }

    private void checkNegativeAmount(final int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Can't deposit a negative amount.");
        }
    }

    public void deposit(final int amount) {
        checkNegativeAmount(amount);
        this.balance = this.balance + amount;
    }

    public void withdraw(final int amount) {
        checkNegativeAmount(amount);
        this.balance = this.balance - amount;
    }
}
