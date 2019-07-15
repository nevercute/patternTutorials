package pro.nevercute.tut.patterns.factorymethod;

import pro.nevercute.tut.patterns.factorymethod.ingredients.PizzaIngredientFactory;

public class NYStyleCheesePizza extends Pizza {
    private PizzaIngredientFactory ingredientFactory;
    public NYStyleCheesePizza(PizzaStore pizzaStore, String pizzaType, PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
        this.pizzaStore = pizzaStore;
        this.pizzaType = pizzaType;
        this.name = "NY Style Cheese Pizza";
    }

    @Override
    void prepare() {
        System.out.println("Preparing "+ name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
