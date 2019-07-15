package pro.nevercute.tut.patterns.adapters.duck;

public class DuckTestDrive {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        Duck duck = new MallardDuck();
        testDuck(duck);
        testDuck(turkeyAdapter);

        DuckAdapter duckAdapter = new DuckAdapter(duck);
        testTurkey(duckAdapter);
        testTurkey(turkey);
    }

    public static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

    public static void testTurkey(Turkey turkey){
        turkey.gobble();
        turkey.fly();
    }
}
