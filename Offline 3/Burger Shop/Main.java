import java.util.Scanner;

public class Main {

    public static void printBurgerInfo(IBurger burger) {
        System.out.println("# ITEMS = " + burger.description());
        System.out.println("# PRICE = " + burger.cost());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while(true) {

            System.out.println();
            System.out.println("1. Beef burger with French fry and cheese");
            System.out.println("2. Veggie burger with onion rings and Bottle of Water");
            System.out.println("3. A combo meal with Veggie burger, French Fry and Coke");
            System.out.println("4. A combo meal with Veggie burger, Onion Rings, Coffee and Water");
            System.out.println("5. A Beef burger only");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if(choice == 1){
                IBurger beefFrenchCheese = new FrenchFryDecorator(new CheddarDecorator(new BeefBurger()));
                printBurgerInfo(beefFrenchCheese);
            }
            else if(choice == 2){
                IBurger veggieOnionWater = new WaterDecorator(new OnionRingDecorator(new VeggieBurger()));
                printBurgerInfo(veggieOnionWater);
            }
            else if(choice == 3){
                IBurger veggieFrenchCoke = new CokeDecorator(new FrenchFryDecorator(new VeggieBurger()));
                printBurgerInfo(veggieFrenchCoke);
            }
            else if(choice == 4){
                IBurger veggieOnionCoffeeWater = new WaterDecorator(new CoffeeDecorator(new OnionRingDecorator(new VeggieBurger())));
                printBurgerInfo(veggieOnionCoffeeWater);
            }
            else if(choice == 5){
                IBurger beefBurgerOnly = new BeefBurger();
                printBurgerInfo(beefBurgerOnly);
            }
            else if (choice == 6){
                System.out.println("Program Terminated");
                break;
            }
            //Extra
            else if (choice == 7){
                IBurger chickenClassicFrenchCoke = new CokeDecorator(new FrenchFryDecorator(new ClassicDecorator(new ChickenBurger())));
                printBurgerInfo(chickenClassicFrenchCoke);
            }
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
