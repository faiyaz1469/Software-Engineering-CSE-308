import java.util.ArrayList;

public abstract class Account {
    public String accountName;
    public float accountBalance;
    public float totalLoan;
    public static final float ANNUAL_FEE = 500;

    public static ArrayList<Account> accountLog = new ArrayList<>();

    public Account() {}

    public Account(String accountName) {

        this.setAccountName(accountName);
        this.setAccountBalance(0);
        updateAccountLog(this);
        Bank.updateFund(0);

    }

    public Account(String accountName, float initialDeposit) {

        this.setAccountName(accountName);
        if(initialDeposit > 0) {
            this.accountBalance = initialDeposit;
            updateAccountLog(this);
            Bank.updateFund(initialDeposit);
        }
        else {
            System.out.println("Invalid amount. Failed to deposit.");
        }
        this.totalLoan = 0;
    }

    public Account(String accountName, float initialLoan, float initialDeposit) {

        this.setAccountName(accountName);
        if(initialLoan > 0) {
            this.totalLoan = initialLoan;
            updateAccountLog(this);
            Bank.updateFund(-initialLoan);
        }
        else {
            System.out.println("Invalid amount. Failed to Loan.");
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }


    public void depositMoney(float amount) {
        if(amount > 0) {
            this.accountBalance += amount;
            updateAccountLog(this);
            Bank.updateFund(amount);
            System.out.println(amount + "$ deposited; current balance " + this.accountBalance + "$");
        }
        else {
            System.out.println("Invalid amount. Failed to deposit.");
        }
    }

    public abstract void withdrawMoney(float amount);

    public abstract int requestLoan(float amount);

    public abstract void updateLoan(float amount);

    public abstract void incrementYear(float intRate);

    public void queryDeposit() {

        if(this.getAccountBalance()>0 && this.totalLoan<=0)
            System.out.println(this.getAccountName() + "'s Current balance " + this.getAccountBalance() + "$");

        if(this.getAccountBalance()>0 && this.totalLoan>0)
            System.out.println(this.getAccountName() + "'s Current balance " + this.getAccountBalance() + "$" + ", loan " + this.totalLoan +"$");

        if(this.totalLoan>0 && this.getAccountBalance() <= 0)
           System.out.print(this.getAccountName() + "'s Current loan " + this.totalLoan +"$");

    }

    public void updateAccountLog(Account newAccount) {
        accountLog.add(newAccount);
    }
}

