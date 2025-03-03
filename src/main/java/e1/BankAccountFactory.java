package e1;

public class BankAccountFactory {

    public BankAccount createSilverBankAccount() {
        return new NoOverdraftBankAccount(new ConstantFeeBankAccount(new CoreBankAccount()));
    }

    public BankAccount createGoldBankAccount() {
        return new OverdraftBankAccount(new CoreBankAccount());
    }
}
