package education.expulsion.decorator.subject;

import education.data.Student;

public class DefaultExpulsion implements Expulsioner {
    @Override
    public void expulsionProcess(Student student) {
        if(student.getSubjectList().hasFailedExam()) {
            student.setConclusion(expel("Failed exams: " + student.getSubjectList().failedExams()));
        } else {
            student.setConclusion(allow("All exams have been passed"));
        }
    }
}
