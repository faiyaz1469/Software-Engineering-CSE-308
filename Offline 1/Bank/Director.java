public class Director extends Employee {

    public Director(String directorName) {
        super(directorName);
    }

    @Override
    public int approveLoan() { return 1; }

    @Override
    public float changeInterestRate(String accountName, float newRate) {
         if(accountName.equalsIgnoreCase("student")){
                System.out.println("New interest rate for student account " + newRate);
         }
         else if(accountName.equalsIgnoreCase("savings")){
               System.out.println("New interest rate for savings account " + newRate);
         }
         else if(accountName.equalsIgnoreCase("fixeddeposit")){
             System.out.println("New interest rate for fixed deposit account " + newRate);
         }
         return 1;
    }

    @Override
    public float queryFund() {
        return Bank.totalFund;
    }

}
