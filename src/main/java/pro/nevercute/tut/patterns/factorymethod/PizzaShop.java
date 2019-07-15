package pro.nevercute.tut.patterns.factorymethod;

public class PizzaShop {
    public static void main(String[] args) {
        PizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("clam");
    }
}
