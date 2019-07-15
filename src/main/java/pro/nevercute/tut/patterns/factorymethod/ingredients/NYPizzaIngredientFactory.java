package pro.nevercute.tut.patterns.factorymethod.ingredients;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough("Thin Crust Dough");
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce("Marinara sauce");
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese("Reggiano Cheese");
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Garlic("Garlic"), new Onion("Red Onion"), new Mushroom("White mushroom"), new RedPepper("Red Pepper")};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni("Sliced pepperoni");
    }

    @Override
    public Clams createClams() {
        return new FreshClams("Fresh ocean clams");
    }
}
