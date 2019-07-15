package pro.nevercute.tut.patterns.complex.duck;

import pro.nevercute.tut.patterns.complex.goose.Goose;
import pro.nevercute.tut.patterns.complex.goose.GooseAdapter;

public class DuckFactory extends AbstractDuckFactory{
    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    public Quackable createDuckLikeGoose() {
        return new GooseAdapter(new Goose());
    }
}
