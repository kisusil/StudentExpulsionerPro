package com.company;

import education.data.Faculty;
import education.data.Student;
import education.expulsion.config.ExpulsionConfig;
import education.expulsion.execution.Executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ExpulsionConfig config = new ExpulsionConfig(
                Boolean.parseBoolean(args[0]),
                Boolean.parseBoolean(args[1]),
                Boolean.parseBoolean(args[2]),
                Boolean.parseBoolean(args[3]),
                Boolean.parseBoolean(args[4]));


        /*
        ExpulsionConfig config = new ExpulsionConfig(
                true,
                true,
                true,
                false,
                true);
         */

        System.out.println(config);

        List<Student> students = new ArrayList<>();

        students.add(new Student("Maria",
                Faculty.ROBOTICS,
                new ArrayList<>(Arrays.asList(true))));
        students.add(new Student("Anastasia",
                Faculty.ROBOTICS,
                new ArrayList<>(Arrays.asList(false))));
        students.add(new Student("Mikhail",
                Faculty.ROBOTICS,
                new ArrayList<>(Arrays.asList(true))));
        students.add(new Student("Ilya",
                Faculty.ROBOTICS,
                new ArrayList<>(Arrays.asList(false))));

        students.add(new Student("Alexey",
                Faculty.SE,
                new ArrayList<>(Arrays.asList(true, true))));
        students.add(new Student("Andrey",
                Faculty.SE,
                new ArrayList<>(Arrays.asList(false, true))));
        students.add(new Student("Olga",
                Faculty.SE,
                new ArrayList<>(Arrays.asList(true, false))));
        students.add(new Student("Oleg",
                Faculty.SE,
                new ArrayList<>(Arrays.asList(false, false))));

        students.add(new Student("Vladimir",
                Faculty.ICE,
                new ArrayList<>(Arrays.asList(true, true))));
        students.add(new Student("Vladislav",
                Faculty.ICE,
                new ArrayList<>(Arrays.asList(false, true))));
        students.add(new Student("Dmitriy",
                Faculty.ICE,
                new ArrayList<>(Arrays.asList(true, false))));
        students.add(new Student("Katherine",
                Faculty.ICE,
                new ArrayList<>(Arrays.asList(false, false))));

        Executor executor = new Executor(students, config);
        executor.execute();


    }
}
