package pro.nevercute.tut.patterns.decorator.starbuzz;

public class StarbuzzCoffe {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        beverage1.setSize("Small");
        beverage1 = new Mocha(beverage1);
        beverage1 = new Soy(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println(beverage1.getDescription() + ": $"+beverage1.cost());
    }
}
