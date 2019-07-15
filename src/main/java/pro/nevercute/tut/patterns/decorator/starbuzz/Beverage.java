package pro.nevercute.tut.patterns.decorator.starbuzz;

public abstract class Beverage {
    protected String description;
    private float cost;
    private String size;

    public Beverage(String name, float cost){
        this.description = name;
        this.cost = cost;
    }

    String getDescription() {
        return this.description;
    }
    abstract float cost();

    public float getCost(){
        return this.cost;
    }

    public void setCost(float cost){
        this.cost = cost;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size = size;
    }
}
