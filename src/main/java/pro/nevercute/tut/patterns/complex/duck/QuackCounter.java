package pro.nevercute.tut.patterns.complex.duck;

public class QuackCounter implements Quackable {
    private Quackable duck;
    private static int quackCount = 0;

    public QuackCounter(Quackable duck){
        this.duck = duck;
    }

    public static int getQuackCount() {
        return quackCount;
    }

    public void performQuack(){
        quackCount++;
    }

    @Override
    public void quack() {
        duck.quack();
        performQuack();
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        duck.removeObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
