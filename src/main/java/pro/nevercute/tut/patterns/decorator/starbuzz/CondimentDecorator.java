package pro.nevercute.tut.patterns.decorator.starbuzz;

public abstract class CondimentDecorator extends Beverage {

    public CondimentDecorator(String name, float cost) {
        super(name, cost);
    }

    abstract String getDescription();

    abstract void setCondimentCost();
}
