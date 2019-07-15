package pro.nevercute.tut.patterns.decorator.starbuzz;

public class Whip extends CondimentDecorator {
    private Beverage beverage;

    public Whip(Beverage beverage) {
        super("Whip", .10f);
        this.beverage = beverage;
        this.setSize(beverage.getSize());
        setCondimentCost();
    }

    @Override
    String getDescription() {
        return beverage.getDescription()+", "+description;
    }

    @Override
    float cost() {
        return getCost()+beverage.cost();
    }

    @Override
    void setCondimentCost() {
        if(beverage.getSize() == "Large")
            setCost(.2f);
        else if (beverage.getSize() == "Medium")
            setCost(.15f);
        else
            setCost(.10f);
    }
}
