package pro.nevercute.tut.patterns.decorator.starbuzz;

public class Milk extends CondimentDecorator {
    private Beverage beverage;
    
    public Milk(Beverage beverage) {
        super("Milk", .10f);
        this.beverage = beverage;
        this.setSize(beverage.getSize());
        setCondimentCost();
    }

    @Override
    String getDescription() {
        return beverage.getDescription()+", "+description;
    }

    @Override
    void setCondimentCost() {
        if(beverage.getSize() == "Large")
            setCost(.20f);
        else if (beverage.getSize() == "Medium")
            setCost(.15f);
        else
            setCost(.10f);
    }

    @Override
    float cost() {
        return getCost()+beverage.getCost();
    }
}
