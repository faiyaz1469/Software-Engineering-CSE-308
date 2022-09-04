public abstract class CheeseDecorator implements IBurger{
    public abstract double cost();
    public abstract double perUnitCost();
    public abstract String description();
}

class CheddarDecorator extends CheeseDecorator{

    private final IBurger burger;

    public CheddarDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + Cheddar Cheese";
    }

    @Override
    public double perUnitCost() {
        return 30.0;
    }

    @Override
    public double cost(){
        return this.burger.cost() + perUnitCost();
    }

}

class ClassicDecorator extends CheeseDecorator{

    private final IBurger burger;

    public ClassicDecorator(IBurger burger) {
        this.burger = burger;
    }

    @Override
    public String description() {
        return this.burger.description() + " + Classic Cheese";
    }

    @Override
    public double perUnitCost() {
        return 20.0;
    }

    @Override
    public double cost() {
        return this.burger.cost() + perUnitCost();
    }
}