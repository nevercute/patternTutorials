package pro.nevercute.tut.patterns.collections.iterator.menu;

import java.util.Iterator;
import java.util.List;

public class Waitress {
    private List<Menu> menus;

    public Waitress(List<Menu> menus){
        this.menus = menus;
    }

    public void printMenu(){
        Iterator menu = menus.iterator();
        System.out.println("MENU\n----\n");
        while(menu.hasNext()){
            Menu m = ((Menu)menu.next());
            System.out.println(m.getMenuType());
            printMenu(m.createIterator());
        }
    }

    private void printMenu(Iterator menuItems){
        while(menuItems.hasNext()){
            MenuItem item = (MenuItem) menuItems.next();
            System.out.println(item.getName());
            System.out.println(item.getPrice());
            System.out.println(item.getDescription()+"\n");
        }
    }

    private void printBreakfastMenu(){

    }

    private void printLunchMenu(){

    }

    private void printVegetarianMenu(){
        
    }

    private boolean isVegeterian(String name){
        return false;
    }
}
