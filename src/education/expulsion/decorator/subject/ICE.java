package education.expulsion.decorator.subject;

import education.data.Student;

public class ICE implements Expulsioner {

    @Override
    public void expulsionProcess(Student student) {
        if(!student.getSubjectList().isPassed("Programming") || !student.getSubjectList().isPassed("OPD")) {
            student.setConclusion(expel(student.getSubjectList().failedExams(), true));
        } else {
            student.setConclusion(allow(false));
        }
    }
}
