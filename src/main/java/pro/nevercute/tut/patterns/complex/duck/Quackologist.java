package pro.nevercute.tut.patterns.complex.duck;

public class Quackologist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quackologist: "+duck+" just quacked");
    }
}
