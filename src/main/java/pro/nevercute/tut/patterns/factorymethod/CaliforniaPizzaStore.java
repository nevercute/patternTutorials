package pro.nevercute.tut.patterns.factorymethod;

public class CaliforniaPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.toUpperCase().equals("CHEESE")){
            pizza = new CaliforniaStyleCheesePizza(this,type);
        }
        else if (type.toUpperCase().equals("PEPPERONI")){
            pizza = new CaliforniaStylePepperoniPizza(this,type);
        }
        else if (type.toUpperCase().equals("CLAM")){
            pizza = new CaliforniaStyleClamPizza(this,type);
        }
        else if (type.toUpperCase().equals("VEGGIE")){
            pizza = new CaliforniaStyleVeggiePizza(this,type);
        }
        return pizza;
    }
}
