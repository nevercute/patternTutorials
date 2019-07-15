package pro.nevercute.tut.patterns.factory;

public class PizzaFactoryImpl implements PizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;
        if (type.toUpperCase().equals("CHEEZE")){
            pizza = new CheezePizza(type);
        }
        else if (type.toUpperCase().equals("PEPPERONI")){
            pizza = new PepperoniPizza(type);
        }
        else if (type.toUpperCase().equals("CLAM")){
            pizza = new ClamPizza(type);
        }
        else if (type.toUpperCase().equals("VEGGIE")){
            pizza = new VeggiePizza(type);
        }
        return pizza;
    }
}
