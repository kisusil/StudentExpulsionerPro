package education.data;

import education.expulsion.decorator.subject.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ответственность за отчисление прешла от Student на Faculty. В данном случае, я считаю, что это логично, когда
 * факультет сам задает правила отчисления своих студентов.
 */
public enum Faculty {
    ICE(
            new ICE(),
            "Informatics and Computer Science",
            new ArrayList<>(Arrays.asList("Programming", "OPD"))),
    SE(
            new SE(),
            "Software engineering",
            new ArrayList<>(Arrays.asList("Programming", "OPD"))),
    ROBOTICS(
            new Robotics(),
            "Robotics",
            new ArrayList<>(Arrays.asList("Programming")));

    private final String description;
    private List<String> subjects;
    private Expulsioner expulsioner;

    Faculty(Expulsioner expulsioner, String description, List<String> subjects) {
        this.description = description;
        this.expulsioner = expulsioner;
        this.subjects = subjects;
    }

    public Expulsioner getExpulsioner() {
        return expulsioner;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return description;
    }
}
