package education.expulsion.decorator.decorator;

import education.data.Student;
import education.expulsion.decorator.subject.Expulsioner;

/**
 * Base decorator
 */
public class ItmoDecorator implements Expulsioner {
    @Override
    public void expulsionProcess(Student student) {
    }
}
