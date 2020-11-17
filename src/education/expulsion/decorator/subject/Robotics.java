package education.expulsion.decorator.subject;

import education.data.Student;

public class Robotics implements Expulsioner{
    @Override
    public void expulsionProcess(Student student) {
        if(!student.getSubjectList().isPassed("Programming")) {
            student.setConclusion(expel(student.getSubjectList().failedExams(), false));
        } else {
            student.setConclusion(allow(false));
        }
    }
}
