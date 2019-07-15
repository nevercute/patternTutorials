package pro.nevercute.tut.patterns.decorator.starbuzz;

public class Mocha extends CondimentDecorator {
    private Beverage beverage;

    public Mocha(Beverage beverage) {
        super("Mocha", .20f);
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
            setCost(.30f);
        else if (beverage.getSize() == "Medium")
            setCost(.25f);
        else
            setCost(.20f);
    }
}
