package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class Queen extends Character {

    public Queen() {
        super(new KnifeBehavior());
        System.out.println("Character Queen is set");
    }

    @Override
    public void fight() {
        getWeaponBehavior().useWeapon();
    }
}
