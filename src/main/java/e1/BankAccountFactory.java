package e1;

public class BankAccountFactory {

    public BankAccount createBronzeBankAccount() {
        final int maxOverdraft = 0;
        final int thresholdAmount = 100;
        final int fee = 1;
        return new OverdraftBankAccount(maxOverdraft, new FeeBankAccount(thresholdAmount, fee, new CoreBankAccount()));
    }

    public BankAccount createSilverBankAccount() {
        final int maxOverdraft = 0;
        final int thresholdAmount = 0;
        final int fee = 1;
        return new OverdraftBankAccount(maxOverdraft, new FeeBankAccount(thresholdAmount, fee, new CoreBankAccount()));
    }

    public BankAccount createGoldBankAccount() {
        final int maxOverdraft = 500;
        return new OverdraftBankAccount(maxOverdraft, new CoreBankAccount());
    }
}
