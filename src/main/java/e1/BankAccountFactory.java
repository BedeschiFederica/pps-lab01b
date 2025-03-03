package e1;

public class BankAccountFactory {

    public BankAccount createSilverBankAccount() {
        return new NoOverdraftBankAccount(new ConstantFeeBankAccount(new CoreBankAccount()));
    }

}
