package pro.nevercute.tut.patterns.chcolate;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private static volatile ChocolateBoiler instance;

    private ChocolateBoiler(){
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance(){
        if(instance == null)
            synchronized (ChocolateBoiler.class){
                if(instance == null)
                    instance = new ChocolateBoiler();
            }
        return instance;
    }

    public void fill(){
        System.out.println("Fill check: isEmpty() = "+(isEmpty()));
        if(isEmpty()) {
            empty = false;
            boiled = false;
        }
        System.out.println("Fill: empty = "+empty+"; boiled = "+boiled);
    }

    public void drain(){
        System.out.println("Drain check: !isEmpty() && isBoiled() = "+(!isEmpty() && isBoiled()));
        if(!isEmpty() && isBoiled()){
            empty = true;
        }
        System.out.println("Drain: empty = "+empty+"; boiled = "+boiled);
    }

    public void boil(){
        System.out.println("Boil check: !isEmpty()&&!isBoiled() = "+(!isEmpty()&&!isBoiled()));
        if(!isEmpty()&&!isBoiled()){
            boiled = true;
        }
        System.out.println("Boil: empty = "+empty+"; boiled = "+boiled);
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
