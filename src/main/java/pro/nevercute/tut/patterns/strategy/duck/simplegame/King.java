package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class King extends Character {
    public King() {
        super(new SwordBehavior());
        System.out.println("Character King is set");
    }

    @Override
    public void fight() {
        getWeaponBehavior().useWeapon();
    }
}
