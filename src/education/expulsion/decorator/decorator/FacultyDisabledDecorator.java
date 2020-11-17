package education.expulsion.decorator.decorator;

import beer.Beer;
import education.data.Student;

public class FacultyDisabledDecorator extends ItmoDecorator {
    @Override
    public void expulsionProcess(Student student) {
        student.setConclusion(allow(Beer.getInstance().giveBeer()));
    }
}
