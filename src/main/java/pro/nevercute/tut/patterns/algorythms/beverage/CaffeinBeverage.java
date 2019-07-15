package pro.nevercute.tut.patterns.algorythms.beverage;

public abstract class CaffeinBeverage {
    public void boilWater(){
        System.out.println("Boiling water");
    }

    public void pourINCap(){
        System.out.println("Pouring into cap");
    }

    final void prepareRecipe(){
        boilWater();
        brew();
        pourINCap();
        if (customerWantsCondiments()) {
            addCondiment();
        }
    }

    public boolean customerWantsCondiments(){
        return true;
    }

    abstract void brew();
    abstract void addCondiment();
}
