public class FixedDepositAccount extends Account {

    public int yearCount = 0;

    public FixedDepositAccount(String accountName, float initialDeposit) {

        super(accountName, initialDeposit);
        System.out.println("Fixed deposit account for " + accountName + " Created; initial balance " + initialDeposit +"$");
    }

    @Override
    public void depositMoney(float amount) {
        if(amount >= 50_000) {
            this.accountBalance += amount;
            updateAccountLog(this);
            Bank.updateFund(amount);
            System.out.println(amount + "$ deposited; current balance " + this.accountBalance + "$");
        }
        else {
            System.out.println("Deposit must be at least 50,000$");
        }
    }

    @Override
    public void withdrawMoney(float amount) {
        if(amount <= this.getAccountBalance() && yearCount >= 1) {
            this.accountBalance -= amount;
            updateAccountLog(this);
            Bank.updateFund(-amount);
            System.out.printf("%.2f$ withdrawn; current balance %.2f\n",amount,this.accountBalance);

        }
        else {
            System.out.println("Invalid transaction; you cannot withdraw since it has not reached a maturity period of one year");
        }
    }

    @Override
    public int requestLoan(float amount) {
        if(amount <= 100_000 && Bank.totalFund - amount > 0 ) {
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
        this.accountBalance += amount;
        updateAccountLog(this);
        Bank.updateFund(-amount);
    }

    @Override
    public void incrementYear(float interestRate) {

        this.yearCount += 1;

        if(this.accountBalance > 0) {
            float reward = this.accountBalance * interestRate;
            this.accountBalance +=  reward;
            Bank.updateFund(-reward);
        }

        this.accountBalance -= ANNUAL_FEE;
        this.accountBalance -= totalLoan*0.1;
        Bank.updateFund(ANNUAL_FEE);
        Bank.updateFund((float) (totalLoan*0.1));

        updateAccountLog(this);
    }

}
