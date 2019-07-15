package pro.nevercute.tut.patterns.complex.goose;

public class Goose implements Honkable {
    @Override
    public void honk() {
        System.out.println("Honk");
    }

    public String toString(){
        return this.getClass().getSimpleName();
    }
}
