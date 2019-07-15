package pro.nevercute.tut.patterns.complex.duck;

public interface QuackObservable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
