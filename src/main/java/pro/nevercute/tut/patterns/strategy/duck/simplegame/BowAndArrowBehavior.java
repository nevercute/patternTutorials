package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Bow and Arrow used");
    }
}
