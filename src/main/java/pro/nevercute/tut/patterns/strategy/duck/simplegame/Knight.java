package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class Knight extends Character {

    public Knight() {
        super(new AxeBehavior());
        System.out.println("Character Knight is set");
    }

    @Override
    public void fight() {
        getWeaponBehavior().useWeapon();
    }
}
