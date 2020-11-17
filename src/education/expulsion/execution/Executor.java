package education.expulsion.execution;

import education.data.Faculty;
import education.data.Student;
import education.expulsion.config.ExpulsionConfig;
import education.expulsion.decorator.decorator.FacultyDisabledDecorator;
import education.expulsion.decorator.decorator.FullMoonDecorator;
import education.expulsion.decorator.decorator.RandomDecorator;
import education.expulsion.decorator.subject.Expulsioner;
import java.util.List;

public class Executor {
    private ExpulsionConfig config;
    private List<Student> students;

    public Executor(List<Student> students, ExpulsionConfig config) {
        this.config = config;
        this.students = students;
    }

    public void execute() {
        for (Student s: students) {
            Expulsioner expulsioner = s.getFaculty().getExpulsioner();
            Faculty faculty = s.getFaculty();

            switch (faculty) {
                case ROBOTICS:
                    if(!config.isRobotics()) {
                        expulsioner = new FacultyDisabledDecorator();
                    }
                    break;
                case ICE:
                    if(!config.isICE()) {
                        expulsioner = new FacultyDisabledDecorator();
                    }
                    if(config.isRandom()) {
                        expulsioner = new RandomDecorator(expulsioner);
                    }
                    break;
                case SE:
                    if(!config.isSE()) {
                        expulsioner = new FacultyDisabledDecorator();
                    }
                    if(!config.isRandom() && config.isFullMoon()) {
                        expulsioner = new FullMoonDecorator(expulsioner);
                    }
            }
            expulsioner.expulsionProcess(s);
            System.out.println(s);
        }
    }
}
