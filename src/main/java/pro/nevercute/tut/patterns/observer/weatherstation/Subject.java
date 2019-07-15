package pro.nevercute.tut.patterns.observer.weatherstation;

public interface Subject {
    void registerObcesrver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
