package education.expulsion.execution;

import education.data.Faculty;
import education.data.Student;
import education.expulsion.config.ExpulsionConfig;
import education.expulsion.decorator.subject.Expulsioner;

import java.util.List;

public class Executor {
    private List<Student> students;
    private ExpulsionConfig config;
    private ExpulsionBuilder roboticsBuilder, iceBuilder, seBuilder;
    private Expulsioner se, ice, robotics;

    public Executor(List<Student> students, ExpulsionConfig config) {
        this.students = students;
        this.config = config;
        roboticsBuilder = new ExpulsionBuilder();
        iceBuilder = new ExpulsionBuilder();
        seBuilder = new ExpulsionBuilder();
    }

    public void configure() {
        // Robotics config
        if(!config.isRoboticsEnabled()) roboticsBuilder.setFacultyDisabled();
        robotics = roboticsBuilder.build();

        // ICE config
        if(!config.isICEEnabled()) iceBuilder.setFacultyDisabled();
        else if(config.isRandom()) iceBuilder.setRandom();
        ice = iceBuilder.build();

        // SE config
        if(!config.isSEEnabled()) seBuilder.setFacultyDisabled();
        else if(!config.isRandom() && config.isFullMoon()) seBuilder.setFullMoon();
        se = seBuilder.build();
    }

    public void execute() {
        configure();
        for (Student s: students) {
            switch (s.getFaculty()) {
                case SE: se.expulsionProcess(s);
                case ICE: ice.expulsionProcess(s);
                case ROBOTICS: robotics.expulsionProcess(s);
            }
        }
        printStudentList();
    }

    public void printStudentList() {
        for (Student s: students) {
            System.out.println(s);
        }
    }
}
