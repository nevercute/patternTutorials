package pro.nevercute.tut.patterns.complex.duck;

import pro.nevercute.tut.patterns.complex.goose.Goose;
import pro.nevercute.tut.patterns.complex.goose.GooseAdapter;

public class CountingDuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    public Quackable createDuckLikeGoose() {
        return new QuackCounter(new GooseAdapter(new Goose()));
    }
}
