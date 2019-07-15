package pro.nevercute.tut.patterns.complex.goose;

import pro.nevercute.tut.patterns.complex.duck.Observable;
import pro.nevercute.tut.patterns.complex.duck.Observer;
import pro.nevercute.tut.patterns.complex.duck.Quackable;

public class GooseAdapter implements Quackable {
    private Observable observable;
    private Honkable goose;

    public GooseAdapter(Honkable goose){
        this.goose = goose;
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        goose.honk();
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observable.registerObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observable.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        this.observable.notifyObservers();
    }

    public String toString(){
        return goose.getClass().getSimpleName();
    }
}
