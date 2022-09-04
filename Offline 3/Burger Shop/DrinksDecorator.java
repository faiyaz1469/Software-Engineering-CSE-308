public abstract class DrinksDecorator implements IBurger {
    public abstract double cost();
    public abstract double perUnitCost();
    public abstract String description();
}

class CoffeeDecorator extends DrinksDecorator {

    private final IBurger burger;

    public CoffeeDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + Coffee";
    }

    @Override
    public double perUnitCost() {
        return 120.0;
    }

    @Override
    public double cost() {
        return this.burger.cost() + perUnitCost();
    }
}

class WaterDecorator extends DrinksDecorator{

    private final IBurger burger;

    public WaterDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + Water";
    }

    @Override
    public double perUnitCost() {
        return 40.0;
    }

    @Override
    public double cost() {
        return this.burger.cost() + perUnitCost();
    }
}

class CokeDecorator extends DrinksDecorator {

    private final IBurger burger;

    public CokeDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + Coke";
    }

    @Override
    public double perUnitCost() {
        return 60.0;
    }

    @Override
    public double cost() {
        return this.burger.cost() + perUnitCost();
    }

}
