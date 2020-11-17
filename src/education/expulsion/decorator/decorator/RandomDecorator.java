package education.expulsion.decorator.decorator;

import education.data.Conclusion;
import education.data.Student;
import education.expulsion.decorator.subject.Expulsioner;
import java.util.Random;

public class RandomDecorator extends ItmoDecorator {
    private Expulsioner expulsioner;

    public RandomDecorator(Expulsioner expulsioner) {
        this.expulsioner = expulsioner;
    }

    @Override
    public void expulsionProcess(Student student) {
        expulsioner.expulsionProcess(student);
        if(!student.getConclusion().isExpelled() && !student.getConclusion().isFinalDecision()) {
            student.setConclusion(new Conclusion(new Random().nextBoolean(), "Coin decision", true));
        }
    }
}
