package pro.nevercute.tut.patterns.strategy.duck.simplegame;

public class GameStart {
    public static void main(String[] args) {
        Character character = new King();
        character.fight();
        character = new Queen();
        character.fight();
        character.setWeaponBehavior(new BowAndArrowBehavior());
        character.fight();
    }
}
