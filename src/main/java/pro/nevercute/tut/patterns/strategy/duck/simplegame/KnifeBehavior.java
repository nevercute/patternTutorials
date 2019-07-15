package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Knife was used");
    }
}
