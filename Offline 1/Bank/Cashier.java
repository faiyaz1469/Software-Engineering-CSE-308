public class Cashier extends Employee {

    public Cashier(String cashierName) {
        super(cashierName);
    }

    @Override
    public float queryFund() {
        return -1;
    }

    @Override
    public float changeInterestRate(String accountName, float newRate) { return -1; }

    @Override
    public int approveLoan(){ return -1; }

}
