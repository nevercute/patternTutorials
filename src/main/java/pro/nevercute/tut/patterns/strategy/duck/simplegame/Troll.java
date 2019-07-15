package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class Troll extends Character {
    public Troll() {
        super(new BowAndArrowBehavior());
        System.out.println("Character Troll is set");
    }

    @Override
    public void fight() {
        getWeaponBehavior().useWeapon();
    }
}
