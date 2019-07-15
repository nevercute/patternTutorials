package pro.nevercute.tut.patterns.factorymethod;

public abstract class PizzaStore {
    abstract Pizza createPizza(String type);

    public void orderPizza(String type){
        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
