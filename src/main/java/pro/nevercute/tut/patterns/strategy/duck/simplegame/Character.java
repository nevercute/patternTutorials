package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public abstract class Character {
    private WeaponBehavior weaponBehavior;

    public Character(WeaponBehavior weaponBehavior){
        this.weaponBehavior = weaponBehavior;
    }

    public abstract void fight();

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public WeaponBehavior getWeaponBehavior() {
        return this.weaponBehavior;
    }
}
