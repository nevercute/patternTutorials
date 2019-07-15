package pro.nevercute.tut.patterns.collections.iterator;

import pro.nevercute.tut.patterns.collections.iterator.menu.MenuItem;

import java.util.Iterator;


public class DinerMenuIterator implements Iterator {
    private MenuItem[] menuItems;
    private int pos = 0;

    public DinerMenuIterator(MenuItem[] items){
        this.menuItems = items;
    }

    @Override
    public boolean hasNext() {
        if(pos >= menuItems.length)
            return false;
        else if (menuItems[pos] == null)
            return false;
        return true;
    }

    @Override
    public Object next() {
        MenuItem item = menuItems[pos];
        pos++;
        return item;
    }

    public void remove(){
        if(pos <= 0){
            throw new UnsupportedOperationException("You must invoke first next() method at least");
        }
        else if (menuItems[pos-1] != null){
            for(int i = pos -1; i < (menuItems.length-1); i++){
                menuItems[i] = menuItems[i+1];
            }
            menuItems[menuItems.length-1] = null;
        }
    }
}
