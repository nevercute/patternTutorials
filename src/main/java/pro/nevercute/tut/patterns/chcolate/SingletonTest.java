package pro.nevercute.tut.patterns.chcolate;

public class SingletonTest {
    public static void main(String[] args) {
        ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();

        boiler1.fill();
        boiler2.fill();
        boiler1.boil();
        boiler2.boil();
        boiler1.drain();
        boiler2.drain();
    }
}
