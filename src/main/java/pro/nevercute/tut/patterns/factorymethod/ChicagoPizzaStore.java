package pro.nevercute.tut.patterns.factorymethod;

public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.toUpperCase().equals("CHEESE")){
            pizza = new ChicagoStyleCheesePizza(this,type);
        }
        else if (type.toUpperCase().equals("PEPPERONI")){
            pizza = new ChicagoStylePepperoniPizza(this,type);
        }
        else if (type.toUpperCase().equals("CLAM")){
            pizza = new ChicagoStyleClamPizza(this,type);
        }
        else if (type.toUpperCase().equals("VEGGIE")){
            pizza = new ChicagoStyleVeggiePizza(this,type);
        }
        return pizza;
    }
}
