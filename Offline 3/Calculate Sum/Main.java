import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum;
        int choice;
        String fileName;

        while(true) {

            System.out.println();
            System.out.println("1. Calculate Sum from Tilde File [Using Adapter]");
            System.out.println("2. Calculate Sum from Decimal File [Using Original]");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if(choice == 1){

                System.out.print("Enter filename: ");
                fileName = sc.next();

                IFileParser adapterParser = new FileParserAdapter(new FileParserAdaptee());

                sum = adapterParser.calculateSumViaAdaptee(fileName);
                System.out.println("Total Sum = " + sum);
            }
            else if(choice == 2){
                System.out.print("Enter filename: ");
                fileName = sc.next();

                FileParserAdaptee originalParser = new FileParserAdaptee();

                sum = originalParser.calculateSum(fileName);
                System.out.println("Total Sum = " + sum);
            }
            else if (choice == 3){
                System.out.println("Program Terminated");
                break;
            }
            else {
                System.out.println("Invalid Choice");
            }

        }
    }
}