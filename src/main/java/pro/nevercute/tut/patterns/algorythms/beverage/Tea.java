package pro.nevercute.tut.patterns.algorythms.beverage;

public class Tea extends CaffeinBeverage{

    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    void addCondiment() {
        System.out.println("Adding a lemon");
    }
}
