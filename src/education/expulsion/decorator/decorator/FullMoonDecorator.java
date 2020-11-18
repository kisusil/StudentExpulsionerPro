package education.expulsion.decorator.decorator;

import education.data.Student;
import education.expulsion.decorator.subject.Expulsioner;

public class FullMoonDecorator extends ItmoDecorator {
    private Expulsioner expulsioner;

    public FullMoonDecorator(Expulsioner expulsioner) {
        this.expulsioner = expulsioner;
    }

    @Override
    public void expulsionProcess(Student student) {
        expulsioner.expulsionProcess(student);
        if(!student.getConclusion().isExpelled()) {
            student.setConclusion(expel("Full moon"));
        }
    }
}
