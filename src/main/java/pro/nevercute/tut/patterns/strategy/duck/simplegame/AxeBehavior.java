package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Axe used");
    }
}
