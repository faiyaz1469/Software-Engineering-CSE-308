public class LoanAccount extends Account{

    public int yearCount = 0;

    public LoanAccount(String accountName, float initialLoan) {
        super(accountName,initialLoan,0);
        System.out.println("Loan account for " + accountName + " Created; initial Loan " + initialLoan +"$");
    }

    @Override
    public void depositMoney(float amount) {
        if(amount > 0) {
            this.totalLoan -= amount;
            updateAccountLog(this);
            Bank.updateFund(amount);
            System.out.println(amount + "$ deposited; current loan " + this.totalLoan + "$");
        }
        else {
            System.out.println("Invalid amount. Failed to deposit.");
        }
    }

    @Override
    public void withdrawMoney(float amount){
        System.out.println("This account can't be used to withdraw money");
    }

    @Override
    public int requestLoan(float amount) {
        if(amount <= this.totalLoan*0.05 && Bank.totalFund - this.totalLoan*0.05 > 0 ) {
            System.out.println("Loan request successful, sent for approval");
            return 1;
        }
        else {
            System.out.println("Loan request denied.");
            return -1;
        }
    }

    @Override
    public void updateLoan(float amount){
        this.totalLoan += amount;
        updateAccountLog(this);
        Bank.updateFund(-amount);
    }

    @Override
    public void incrementYear(float interestRate) {
        this.yearCount += 1;

        if(this.totalLoan > 0) {
            this.totalLoan += totalLoan * 0.1;
        }

        Bank.updateFund((float) (totalLoan*0.1));

        updateAccountLog(this);

    }
}
