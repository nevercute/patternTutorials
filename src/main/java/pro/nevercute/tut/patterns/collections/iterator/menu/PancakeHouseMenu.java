package pro.nevercute.tut.patterns.collections.iterator.menu;

import pro.nevercute.tut.patterns.collections.iterator.PancakeHouseMenuIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private String menuType = "LUNCH";

    public PancakeHouseMenu(){
        addItem("K&B's Pancake Breakfast",
                "Pancakes with scrammed eggs, and toast",
                true,
                2.99);
        addItem("Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99);
        addItem("Blueberry Pancakes",
                "Pancakes made with fresh blueberry",
                true,
                3.49);
        addItem("Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59);
    }

    public boolean addItem(String name, String description, boolean vegetarian, double price){
        return menuItems.add(new MenuItem(name, description, vegetarian, price));
    }

    public Iterator createIterator(){
        return new PancakeHouseMenuIterator(menuItems);
    }

    public String getMenuType() {
        return menuType;
    }
}
