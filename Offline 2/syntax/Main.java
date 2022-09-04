/** Assignment 2, Problem 2
 * Syntax Highlighting
 * This program demonstrates Factory Design Pattern
 * This program shows the implementation of Singleton Factory Pattern
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Editor editor = Editor.getInstance();

        Parser parser;

        while (true) {

            System.out.println("Enter Q to Exit.");
            System.out.print("Enter a file name with extension> \n");
            String fileName = sc.next();

            if(fileName.equalsIgnoreCase("Q")){
                System.out.println("\nPROGRAM TERMINATED\n");
                System.exit(0);
            }
            else{

                parser = editor.LanguageParser(fileName);

                if(parser == null)
                    System.out.println("Invalid filename!!");
                else {
                    parser.parseLanguage();
                    System.out.println("=================================");
                }
            }

            System.out.println();

        }
    }
}
