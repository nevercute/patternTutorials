package pro.nevercute.tut.patterns.collections.composite;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print(){
        System.out.print(" "+getName());
        if(isVegetarian()){
            System.out.print("(Veg)");
        }
        System.out.println(", " + getPrice());
        System.out.println("     --"+getDescription());
    }

    @Override
    public Iterator createIterator() {
        return new NullIterator();
    }
}
