package pro.nevercute.tut.patterns.decorator.starbuzz;

public class Espresso extends Beverage {
    public Espresso() {
        super("Espresso", 1.99f);
    }

    @Override
    float cost() {
        return getCost();
    }
}
