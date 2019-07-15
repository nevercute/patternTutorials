package pro.nevercute.tut.patterns.collections.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    private Iterator iterator = null;
    private List<MenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent){
        this.menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent){
        this.menuComponents.remove(menuComponent);
    }

    public MenuComponent getMenuComponent(int i){
        return this.menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void print(){
        System.out.print("\n"+getName());
        System.out.println(", "+getDescription());
        System.out.println("---------------------");

        Iterator iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            ((MenuComponent) iterator.next()).print();
        }
    }

    @Override
    public Iterator createIterator() {
        if(iterator == null){
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
