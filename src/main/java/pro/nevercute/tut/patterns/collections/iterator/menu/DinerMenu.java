package pro.nevercute.tut.patterns.collections.iterator.menu;

import pro.nevercute.tut.patterns.collections.iterator.DinerMenuIterator;

import java.util.Iterator;

public class DinerMenu implements Menu {
    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems = new MenuItem[MAX_ITEMS];
    private String menuType = "DINNER";

    public DinerMenu(){
        addItem("Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true,
                2.99);
        addItem("BLT",
                "Bacon with lettuce & tomato on whole wheat",
                false,
                2.99);
        addItem("Soup of the day",
                "Soup of the day, with a side of potato salad",
                false,
                3.99);
        addItem("HotDog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);
    }

    public boolean addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name,description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS){
            System.out.println("Menu is full, can't add item to list");
            return false;
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
            return true;
        }
    }

    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }

    public String getMenuType(){
        return this.menuType;
    }
}
