package pro.nevercute.tut.patterns.decorator.starbuzz;

public class HouseBlend extends Beverage {
    public HouseBlend(){
        super("HouseBlend", .89f);
    }

    @Override
    float cost() {
        return getCost();
    }
}
