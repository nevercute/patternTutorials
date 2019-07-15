package pro.nevercute.tut.patterns.collections.iterator;

import pro.nevercute.tut.patterns.collections.iterator.menu.MenuItem;

import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenuIterator implements Iterator {
    private Iterator menuIterator;

    public PancakeHouseMenuIterator(List<MenuItem> items){
        menuIterator = items.iterator();
    }

    @Override
    public boolean hasNext() {
        return menuIterator.hasNext();
    }

    @Override
    public Object next() {
        return menuIterator.next();
    }

    public void remove(){
        menuIterator.remove();
    }
}
