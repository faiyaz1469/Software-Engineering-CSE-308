/** Assignment 2, Problem 1
 * Queue Management System
 * This program demonstrates Factory Design Pattern.
 * This program shows the implementation of Builder Pattern in Factory Pattern
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        QueueBuilder queueBuilder = new QueueBuilder();
        Scanner sc = new Scanner(System.in);

        int choice;
        int displayUnits;
        int connectionChoice;

        System.out.println("\nWELCOME TO QUEUE MANAGEMENT SYSTEM!\n");

        while (true) {

            while (true) {

                System.out.println("=================================================");
                System.out.println("1 Deluxe: LCD panel with Raspberry Pi");
                System.out.println("2 Optimal: Arduino Mega with LED matrix");
                System.out.println("3 Poor: ATMega32 with LED matrix");
                System.out.println("4 Quit");
                System.out.println("=================================================");
                System.out.print("Enter your choice> ");
                choice = sc.nextInt();

                if (choice == 1) {
                    queueBuilder.setQueue(new Deluxe());
                    System.out.println("\n\t[ Deluxe ]");
                    break;
                }

                else if (choice == 2) {
                    queueBuilder.setQueue(new Optimal());
                    System.out.println("\n\t[ Optimal ]");
                    break;
                }

                else if (choice == 3) {
                    queueBuilder.setQueue(new Poor());
                    System.out.println("\n\t[ Poor ]");
                    break;
                }

                else if (choice == 4) {
                    System.out.println("\nPROGRAM TERMINATED\n");
                    System.exit(0);
                }

                else
                    System.out.println("Wrong choice!!\n");
            }

            while (true) {

                System.out.println("# Choose preferred connectivity");
                System.out.println("1. Broadband service");
                System.out.println("2. Mobile data service");
                System.out.print("> ");

                connectionChoice = sc.nextInt();

                if (connectionChoice == 1) {
                    queueBuilder.setConnectivity(new Broadband());
                    break;
                }

                else if (connectionChoice == 2) {
                    queueBuilder.setConnectivity(new MobileData());
                    break;
                }

                else
                    System.out.println("Wrong choice!!\n");

            }

            System.out.println("# Number of display units");
            System.out.print("> ");
            displayUnits = sc.nextInt();
            queueBuilder.setDisplayUnitsNumber(displayUnits);

            System.out.println(queueBuilder.getQueue());
            System.out.println();
            System.out.println();
        }
    }
}
