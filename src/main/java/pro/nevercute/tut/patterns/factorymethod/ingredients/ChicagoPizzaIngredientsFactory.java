package pro.nevercute.tut.patterns.factorymethod.ingredients;

public class ChicagoPizzaIngredientsFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new Dough("Thick Crust Dough");
    }

    @Override
    public Sauce createSauce() {
        return new Sauce("Plum Tomato Sauce");
    }

    @Override
    public Cheese createCheese() {
        return new Cheese("Mozzarella cheese");
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Veggies("Spinach"), new Veggies("Black Olives"), new Veggies("Chicago White mushroom"), new Veggies("Eggplant")};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new Pepperoni("Sliced Pepperoni");
    }

    @Override
    public Clams createClams() {
        return new Clams("Frozen Clams");
    }
}
