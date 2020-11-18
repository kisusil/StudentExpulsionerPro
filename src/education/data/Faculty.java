package education.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ответственность за отчисление прешла от Student на Faculty. В данном случае, я считаю, что это логично, когда
 * факультет сам задает правила отчисления своих студентов.
 */
public enum Faculty {
    ICE(
            "Informatics and Computer Science",
            new ArrayList<>(Arrays.asList("Programming", "OPD"))),
    SE(
            "Software engineering",
            new ArrayList<>(Arrays.asList("Programming", "OPD"))),
    ROBOTICS(
            "Robotics",
            new ArrayList<>(Arrays.asList("Programming")));

    private final String description;
    private List<String> subjects;

    Faculty(String description, List<String> subjects) {
        this.description = description;
        this.subjects = subjects;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return description;
    }
}
