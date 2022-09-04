public interface IBurger {
    String description();
    double cost();
}


class VeggieBurger implements IBurger{

    @Override
    public String description() {
        return "Veggie Burger";
    }

    @Override
    public double cost() {
        return 150.0;
    }
}


class BeefBurger implements IBurger{

    @Override
    public String description() {
        return "Beef Burger";
    }

    @Override
    public double cost() {
        return 280.0;
    }
}


class ChickenBurger implements IBurger{

    @Override
    public String description() {
        return "Chicken Burger";
    }

    @Override
    public double cost() {
        return 220.0;
    }
}
