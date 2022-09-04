class Officer extends Employee {

    public Officer(String officerName) {
        super(officerName);
    }

    @Override
    public int approveLoan() { return 1; }

    @Override
    public float queryFund() { return -1; }

    @Override
    public float changeInterestRate(String accountName, float newRate) { return -1; }

}
