package education.expulsion.execution;

import education.expulsion.decorator.decorator.FacultyDisabledDecorator;
import education.expulsion.decorator.decorator.FullMoonDecorator;
import education.expulsion.decorator.decorator.RandomDecorator;
import education.expulsion.decorator.subject.Expulsioner;
import education.expulsion.decorator.subject.DefaultExpulsion;

public class ExpulsionBuilder {

    Expulsioner expulsioner;

    public ExpulsionBuilder() {
        expulsioner = new DefaultExpulsion();
    }

    public ExpulsionBuilder setFacultyDisabled() {
        expulsioner = new FacultyDisabledDecorator();
        return this;
    }

    public ExpulsionBuilder setRandom() {
        expulsioner = new RandomDecorator(expulsioner);
        return this;
    }

    public ExpulsionBuilder setFullMoon() {
        expulsioner = new FullMoonDecorator(expulsioner);
        return this;
    }

    public Expulsioner build() {
        return expulsioner;
    }
}