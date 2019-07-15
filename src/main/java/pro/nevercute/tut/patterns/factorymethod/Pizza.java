package pro.nevercute.tut.patterns.factorymethod;

import pro.nevercute.tut.patterns.factorymethod.ingredients.*;

import java.util.ArrayList;

public abstract class Pizza {
     PizzaStore pizzaStore;
     String name;
     String pizzaType;
     ArrayList<String> toppings = new ArrayList<>();
     Dough dough;
     Sauce sauce;
     Veggies[] veggies;
     Cheese cheese;
     Pepperoni pepperoni;
     Clams clams;

    abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting pizza into diagonal slices");
    }
    
    public void box() {
        System.out.println("Place pizza in official "+pizzaStore.getClass().getSimpleName()+" box");
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void addTopping(String topping) {
        this.toppings.add(topping);
    }

    public PizzaStore getPizzaStore() {
        return pizzaStore;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
