package pro.nevercute.tut.patterns.algorythms.beverage;

public class PrepareBeverage {

    public static void main(String[] args) {
        CaffeinBeverage tea = new Tea();
        CaffeinBeverage coffie = new Coffee();

        tea.prepareRecipe();
        coffie.prepareRecipe();
    }
}
