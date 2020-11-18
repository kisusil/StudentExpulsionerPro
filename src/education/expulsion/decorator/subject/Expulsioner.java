package education.expulsion.decorator.subject;

import education.data.Conclusion;
import education.data.Student;

/**
 * Subject
 */
public interface Expulsioner {

    void expulsionProcess(Student student);

    default Conclusion allow(String clarification) {
        return new Conclusion(false, clarification);
    }
    default Conclusion expel(String clarification) {
        return new Conclusion(true, clarification);
    }
}
