package pro.nevercute.tut.patterns.factorymethod;

import pro.nevercute.tut.patterns.factorymethod.ingredients.NYPizzaIngredientFactory;
import pro.nevercute.tut.patterns.factorymethod.ingredients.PizzaIngredientFactory;

public class NYPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.toUpperCase().equals("CHEESE")){
            pizza = new NYStyleCheesePizza(this,type,ingredientFactory);
        }
        else if (type.toUpperCase().equals("PEPPERONI")){
            pizza = new NYStylePepperoniPizza(this,type);
        }
        else if (type.toUpperCase().equals("CLAM")){
            pizza = new ClamPizza(ingredientFactory, this);
            pizza.setName("NY Style Clam Pizza");
        }
        else if (type.toUpperCase().equals("VEGGIE")){
            pizza = new NYStyleVeggiePizza(this,type);
        }
        return pizza;
    }
}
