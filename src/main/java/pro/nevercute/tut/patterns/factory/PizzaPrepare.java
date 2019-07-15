package pro.nevercute.tut.patterns.factory;

public class PizzaPrepare {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactoryImpl();
        Pizza pizza = pizzaFactory.createPizza("Cheeze");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        pizza = pizzaFactory.createPizza("Clam");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
