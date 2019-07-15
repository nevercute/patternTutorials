package pro.nevercute.tut.patterns.decorator.starbuzz;

public class DarkRoast extends Beverage {
    public DarkRoast() {
        super("DarkRoast", .99f);
    }

    @Override
    float cost() {
        return getCost();
    }
}
