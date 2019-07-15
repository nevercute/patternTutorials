package pro.nevercute.tut.patterns.adapters.duck;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Turkey gobble");
    }

    @Override
    public void fly() {
        System.out.println("Turkey flying");
    }
}
