package pro.nevercute.tut.patterns.adapters.iteratorenum;

import java.util.Enumeration;
import java.util.Iterator;

public class IteratorAdapter<T> implements Enumeration {
    private T t;
    private Iterator iterator;

    public IteratorAdapter(Iterator iterator){
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public T nextElement() {
        return (T) iterator.next();
    }
}
