package pro.nevercute.tut.patterns.complex.duck;

public class MallardDuck implements Quackable {
    private Observable observable;

    public MallardDuck(){
        this.observable = new Observable(this);
    }

    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observable.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    public String toString(){
        return this.getClass().getSimpleName();
    }
}
