package pro.nevercute.tut.patterns.factory;

public abstract class AbstractPizza implements Pizza {
    private Pizza pizza;
    private String pizzaType;

    public AbstractPizza(String pizzaType){
        this.pizzaType = pizzaType;
    }

    @Override
    public void prepare() {
        System.out.println(this.getClass().getName()+" prepared");
    }

    @Override
    public void bake() {
        System.out.println(this.getClass().getName()+" baked");
    }

    @Override
    public void cut() {
        System.out.println(this.getClass().getName()+" cutted");
    }

    @Override
    public void box() {
        System.out.println(this.getClass().getName()+" boxed");
    }
    
}
