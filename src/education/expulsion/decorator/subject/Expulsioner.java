package education.expulsion.decorator.subject;

import education.data.Conclusion;
import education.data.Student;

/**
 * Subject
 */
public interface Expulsioner {

    void expulsionProcess(Student student);

    /**
     * @param isFinalDecision - параметр отвечает за изменение решения об исключения.
     *                        При передаче true другие декораторы уже не смогут изменить его.
     *                        К примеру, если факультет выключен в конфигураторе, то сколько бы декораторов
     *                        мы не добавляли объекту, решение об отчислении всегда будет отрицательным. То же
     *                        самое касается Random и FullMoon.
     *
     * В наборе есть два стандартных метода, allow и expel, которые применяются для стандартного отчисления/неотчисления
     * (За долги). Перегруженные версии этих методов, которые принимают строку clarification нужны
     * для декораторов, которые передают свои причины, таким образом, при увеличении декораторов
     * код в этом интерфейсе не нужно будет изменять. Единственное, все декораторы дают
     * окончательное решение об отчислении, в дальнейшем, если будут такие декораторы, решение которых
     * можно изменить, то придется перегрузить эти методы (или изменить).
     */
    default Conclusion allow(boolean isFinalDecision) {
        return new Conclusion(false, "All exams have been passed", isFinalDecision);
    }

    default Conclusion allow(String clarification) {
        return new Conclusion(false, clarification, true);
    }

    default Conclusion expel(String failedSubjects, boolean isFinalDecision) {
        return new Conclusion(true, "Failed exams: " + failedSubjects, isFinalDecision);
    }

    default Conclusion expel(String clarification) {
        return new Conclusion(true, clarification, true);
    }
}
