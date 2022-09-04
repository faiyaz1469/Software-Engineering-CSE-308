public class Bank {

    public static float totalFund = 1000000;
    public static Employee director;
    public static Employee officer1;
    public static Employee officer2;
    public static Employee cashier1;
    public static Employee cashier2;
    public static Employee cashier3;
    public static Employee cashier4;
    public static Employee cashier5;

    public Bank() {

        System.out.print("Bank Created;");
        director = new Director("MD");
        officer1 = new Officer("S1");
        officer2 = new Officer("S2");
        cashier1 = new Cashier("C1");
        cashier2 = new Cashier("C2");
        cashier3 = new Cashier("C3");
        cashier4 = new Cashier("C4");
        cashier5 = new Cashier("C5");

        System.out.println(" MD,S1,S2,C1,C2,C3,C4,C5 created");

    }


    public Employee employeeReference(String name) {
        for(Employee emp:Employee.employeeLog) {
            if(emp.employeeName.equalsIgnoreCase(name)) {
                return emp;
            }
        }
        return null;
    }

    public static void updateFund(float amount) {
        totalFund = totalFund + amount;
    }


}
