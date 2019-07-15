package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Sword used");
    }
}
