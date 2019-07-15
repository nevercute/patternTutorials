package pro.nevercute.tut.patterns.factorymethod;

import pro.nevercute.tut.patterns.factorymethod.ingredients.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
    PizzaIngredientFactory pizzaIngredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory, PizzaStore pizzaStore){
        this.pizzaIngredientFactory = pizzaIngredientFactory;
        this.pizzaStore = pizzaStore;
    }

    @Override
    void prepare() {
        System.out.println("Preparing "+ name);
        dough = pizzaIngredientFactory.createDough();
        sauce = pizzaIngredientFactory.createSauce();
        cheese = pizzaIngredientFactory.createCheese();
        clams = pizzaIngredientFactory.createClams();       
    }
}
