package pro.nevercute.tut.patterns.complex.duck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackable {
    private Observable observable;
    private List<Quackable> quackers = new ArrayList<>();

    public Flock(){
        this.observable = new Observable(this);
    }

    public void add(Quackable quack){
        quackers.add(quack);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable duck  = iterator.next();
            duck.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable duck  = iterator.next();
            duck.registerObserver(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Iterator<Quackable> iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable duck  = iterator.next();
            duck.removeObserver(observer);
        }
    }

    @Override
    public void notifyObservers() { }
}
