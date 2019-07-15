package pro.nevercute.tut.patterns.collections.composite;

import java.util.Iterator;

public class Waitress {
    private MenuComponent allMenus;


    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void print(){
        allMenus.print();
    }

    public void printVegetarianMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.print("\nVegetarian Menu\n------------");
        while(iterator.hasNext()){
            MenuComponent component =
                    (MenuComponent) iterator.next();
            try{
                if(component.isVegetarian())
                    component.print();
            }
            catch(UnsupportedOperationException e){
                System.out.println(component.getName()+" not support isVegetarian method");
            }
        }
    }
}
