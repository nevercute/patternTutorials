package pro.nevercute.tut.patterns.adapters.iteratorenum;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationAdapter<T> implements Iterator {
    T t;
    private Enumeration enumeration;

    public EnumerationAdapter(Enumeration enumeration){
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return (T) enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Enumeration has no remove method");
    }
}
