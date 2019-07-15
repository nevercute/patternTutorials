package pro.nevercute.tut.patterns.collections.iterator.menu;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
    String getMenuType();
}
