package e1;

public interface BankAccount {

    /**
     * Returns the current balance of the bank account.
     *
     * @return the current balance
     */
    int getBalance();

    /**
     * Allows the deposit of an amount on the account.
     *
     * @param amount the amount of the deposit
     * @throws IllegalArgumentException if the amount is negative
     */
    void deposit(int amount);

    /**
     * Allows the withdrawal of an amount from the account.
     *
     * @param amount the amount of the withdrawal
     * @throws IllegalArgumentException if the amount is negative
     */
    void withdraw(int amount);

}
