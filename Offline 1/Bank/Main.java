import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank xyzBank = new Bank();
        Scanner sc = new Scanner(System.in);

        String name;
        String accountType;
        float deposit;
        String operation;
        float interestRateStudent = 0.05f;
        float interestRateSavings = 0.10f;
        float interestRateFixedDeposit = 0.15f;
        Account account1 = null;
        Employee emp = null;
        HashMap<String,String> hm = new HashMap<>();
        List<String > ls = new ArrayList<>();
        HashMap<String,Float> loanHash = new HashMap<>();
        List<String > loanList = new ArrayList<>();

        while (true){
            operation = sc.next();
            if(operation.equalsIgnoreCase("create")){

                account1=null;
                name = sc.next();
                accountType = sc.next();
                deposit = sc.nextFloat();

                for(Account obj:Account.accountLog) {
                    if(obj.accountName.equalsIgnoreCase(name)) {
                        System.out.println("An account already exists with the name.");
                        account1 = obj;
                        break;
                    }
                }

                if(account1 == null) {
                    hm.put(name,accountType);
                    ls.add(name);
                    if(accountType.equalsIgnoreCase("savings"))
                        account1 = new SavingsAccount(name, deposit);

                    else if(accountType.equalsIgnoreCase("student"))
                        account1 = new StudentAccount(name, deposit);

                    else if(accountType.equalsIgnoreCase("fixeddeposit")){

                        if(deposit >= 100000)
                            account1 = new FixedDepositAccount(name, deposit);
                        else
                           System.out.println("Initial deposit must be at least 100,000$");

                    }

                    else if(accountType.equalsIgnoreCase("loan"))
                        account1 = new LoanAccount(name, deposit);
                }
            }

            else if(operation.equalsIgnoreCase("deposit")){
                float amount1 = sc.nextFloat();
                if(account1!=null)
                    account1.depositMoney(amount1);
                else
                    System.out.println("Invalid Operation!!");

            }

            else if(operation.equalsIgnoreCase("withdraw")){
                float amount2 = sc.nextFloat();
                if(account1!=null)
                    account1.withdrawMoney(amount2);
                else
                    System.out.println("Invalid Operation!!");
            }

            else if(operation.equalsIgnoreCase("request")){
                float loanAmount = sc.nextFloat();
                if(account1!=null) {
                    int val = account1.requestLoan(loanAmount);
                    if(val == 1) {
                        loanHash.put(account1.accountName, loanAmount);
                        loanList.add(account1.accountName);
                    }
                }
                else
                    System.out.println("Invalid Operation!!");
            }

            else if(operation.equalsIgnoreCase("query")){
                if(account1!=null)
                    account1.queryDeposit();
                else
                    System.out.println("Invalid Operation!!");
            }

            else if(operation.equalsIgnoreCase("open")){
                String name1 = sc.next();
                if(xyzBank.employeeReference(name1)!= null){
                    emp = xyzBank.employeeReference(name1);
                    int number = loanHash.size();
                    openCheck(name1,number);
                }
                else {
                    for (Account obj : Account.accountLog) {
                        if (obj.accountName.equalsIgnoreCase(name1)) {
                            account1 = obj;
                            System.out.println("Welcome back, " + name1);
                            break;
                        }
                    }
                        if(account1 == null)
                            System.out.println("There is no customer/employee with this name");
                }
            }

            else if(operation.equalsIgnoreCase("approve")){

                float loan = 0;
                if(emp!=null) {
                    if (emp.approveLoan() != -1){
                        for(int i = 0; i<loanList.size(); i++){
                            String temp = loanList.get(i);
                            for(Account obj:Account.accountLog) {
                                if(obj.accountName.equalsIgnoreCase(temp)) {
                                    account1 = obj;
                                    loan = loanHash.get(loanList.get(i));
                                    break;
                                }
                            }
                            account1.updateLoan(loan);
                            System.out.println("Loan for " + account1.accountName + " approved");
                        }
                        loanHash = new HashMap<>();
                        loanList = new ArrayList<>();
                        account1 = null;
                    }
                    else
                        System.out.println("You don’t have permission for this operation");
                }
                else
                    System.out.println("Invalid Operation !!");

            }

            else if(operation.equalsIgnoreCase("change")){
                String accType = sc.next();
                float newRate = sc.nextFloat();
                if(emp!=null) {
                    if (emp.changeInterestRate(accType,newRate) != -1){

                        if(accType.equalsIgnoreCase("student"))
                            interestRateStudent = newRate/100;
                        else if(accType.equalsIgnoreCase("savings"))
                            interestRateSavings = newRate/100;
                        else if(accType.equalsIgnoreCase("fixeddeposit"))
                            interestRateFixedDeposit = newRate/100;
                        else
                            System.out.println("This account doesn't have an interest rate");

                    }
                    else
                        System.out.println("You don’t have permission for this operation");
                }
                else
                    System.out.println("Invalid Operation!!");

            }

            else if(operation.equalsIgnoreCase("lookup")){
                String accountName = sc.next();
                if(emp!=null)
                    emp.lookupCustomerAccount(accountName);
                else
                    System.out.println("Invalid Operation !!");
            }

            else if(operation.equalsIgnoreCase("see")){
                if(emp!=null) {

                    if(emp.queryFund() != -1)
                        System.out.println("Total fund of the bank " + emp.queryFund());
                    else
                        System.out.println("You don’t have permission for this operation");
                }
                else
                    System.out.println("Invalid operation !!");

            }

            else if(operation.equalsIgnoreCase("inc")){

                System.out.println("1 year passed");
                for(int i = 0; i<ls.size(); i++){
                    String temp = ls.get(i);
                    String accType = "";
                     for(Account obj:Account.accountLog) {
                        if(obj.accountName.equalsIgnoreCase(temp)) {
                            account1 = obj;
                            accType = hm.get(temp);
                            break;
                        }
                    }
                    if(accType.equalsIgnoreCase("student"))
                        account1.incrementYear(interestRateStudent);

                    else if(accType.equalsIgnoreCase("savings"))
                        account1.incrementYear(interestRateSavings);

                    else if(accType.equalsIgnoreCase("fixeddeposit"))
                        account1.incrementYear(interestRateFixedDeposit);

                    else
                        account1.incrementYear(0.0f);
                }
            }

            else if(operation.equalsIgnoreCase("close")){
                if(account1 != null) {
                    System.out.println("Transaction Closed for " + account1.accountName);
                    account1 = null;
                }
                else if(emp != null){
                    System.out.println("Operations for " + emp.employeeName +" closed");
                }
            }

            else if(operation.equalsIgnoreCase("exit")){
                  break;
            }
        }
    }

     static void openCheck(String s, int num){

        if(s.equalsIgnoreCase("md")){
            if(num == 0)
                System.out.println(s + " active, there is no loan approval pending");
            else
                System.out.println(s + " active, there are loan approvals pending");

        }
        else if(s.equalsIgnoreCase("s1") || s.equalsIgnoreCase("s2")){
                if(num == 0)
                    System.out.println(s + " active, there is no loan approval pending");
                else
                    System.out.println(s + " active, there are loan approvals pending");
        }
        else if(s.equalsIgnoreCase("c1") || s.equalsIgnoreCase("c2") || s.equalsIgnoreCase("c3")
        || s.equalsIgnoreCase("c4") || s.equalsIgnoreCase("c5")){
            System.out.println(s + " active.");
        }
        else {
            System.out.println(s + " not in database");
        }
    }
}
