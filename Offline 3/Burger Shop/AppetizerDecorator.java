public abstract class AppetizerDecorator implements IBurger {
    public abstract double cost();
    public abstract double perUnitCost();
    public abstract String description();
}

class OnionRingDecorator extends AppetizerDecorator {
    private final IBurger burger;

    public OnionRingDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + Onion Ring";
    }

    @Override
    public double perUnitCost() {
        return 80.0;
    }

    @Override
    public double cost() {
        return this.burger.cost() + perUnitCost();
    }

}

class FrenchFryDecorator extends AppetizerDecorator {

    private final IBurger burger;

    public FrenchFryDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + French Fry";
    }

    @Override
    public double perUnitCost() {
        return 100.0;
    }

    @Override
    public double cost() {
        return this.burger.cost() + perUnitCost();
    }

}


