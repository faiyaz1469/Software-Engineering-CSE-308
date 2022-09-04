import java.util.ArrayList;

public abstract class Employee {
    public String employeeName;

    public static ArrayList<Employee> employeeLog = new ArrayList<>();

    public Employee(String employeeName) {
        this.employeeName = employeeName;
        updateEmployeeLog(this);
    }

    public void lookupCustomerAccount(String accountName) {
        boolean present = false;
        for(Account obj:Account.accountLog) {

            if(obj.accountName.equalsIgnoreCase(accountName)) {
                float balance = obj.accountBalance;
                float loan = obj.totalLoan;
                if(balance>0 && loan<=0)
                    System.out.println(accountName + "'s Current balance " + balance +"$");
                if(balance>0 && loan>0)
                    System.out.println(accountName + "'s Current balance " + balance + "$" + ", loan " + loan +"$");
                if(loan>0 && balance <= 0)
                    System.out.print(accountName + "'s Current loan " + loan +"$");

                present = true;
                break;
            }
        }
        if(!present)
            System.out.println("Account Not present in Database");
    }


    public abstract int approveLoan();

    public abstract float queryFund();

    public abstract float changeInterestRate(String accountName, float newRate);

    public void updateEmployeeLog(Employee emp) {
        employeeLog.add(emp);
    }

}


