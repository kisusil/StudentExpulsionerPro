package education.expulsion.execution;

import education.data.Student;
import education.expulsion.config.ExpulsionConfig;
import education.expulsion.decorator.subject.Expulsioner;
import javafx.util.Builder;

import java.util.List;

public class Executor {
    private List<Student> students;
    private ExpulsionConfig config;

    public Executor(List<Student> students, ExpulsionConfig config) {
        this.students = students;
        this.config = config;
    }


    public void execute() {
        for (Student s: students) {
            ExpulsionBuilder builder = new ExpulsionBuilder();
            builder.setFacultyDisabled(config.checkFacultyState(s.getFaculty()));
            if(!s.getConclusion().isExpelled()) {
                switch (s.getFaculty()) {
                    case ROBOTICS:
                        // Здесь у нас по сути ничего не делается, т.к. студенты отчисляются только по факту долга
                        // DefaultExpulsion включен по умолчанию.
                        break;
                    case ICE:
                        builder.setRandom(config.isRandom() && config.checkFacultyState(s.getFaculty()));
                        break;
                    case SE:
                        builder.setFullMoon(config.isFullMoon() && !config.isRandom());
                        break;
                }
            }
            Expulsioner expulsioner = builder.build();
            expulsioner.expulsionProcess(s);
            System.out.println(s);
        }
    }
}
