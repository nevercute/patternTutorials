package pro.nevercute.tut.patterns.decorator.starbuzz;

public class Soy extends CondimentDecorator {
    private Beverage beverage;
    
    public Soy(Beverage beverage) {
        super("Soy", .15f);
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
            setCost(.25f);
        else if (beverage.getSize() == "Medium")
            setCost(.2f);
        else
            setCost(.15f);
    }
}
