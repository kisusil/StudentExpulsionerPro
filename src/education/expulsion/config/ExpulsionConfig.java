package education.expulsion.config;

import beer.Beer;
import education.data.Faculty;
import education.expulsion.execution.ExpulsionBuilder;

import java.util.Formatter;

public class ExpulsionConfig {

    private boolean isFullMoon;
    private boolean isRandom;
    private boolean robotics;
    private boolean ICE;
    private boolean SE;
    private ExpulsionBuilder builder;


    public ExpulsionConfig(boolean robotics,
                           boolean ICE,
                           boolean SE,
                           boolean isFullMoon,
                           boolean isRandom) {
        this.isFullMoon = isFullMoon;
        this.isRandom = isRandom;
        this.robotics = robotics;
        this.ICE = ICE;
        this.SE = SE;
    }

    public boolean isFullMoon() {
        return isFullMoon;
    }
    public boolean isRandom() {
        return isRandom;
    }
    public boolean isRobotics() {
        return robotics;
    }
    public boolean isICE() {
        return ICE;
    }
    public boolean isSE() {
        return SE;
    }

    public boolean checkFacultyState(Faculty faculty) {
        switch (faculty) {
            case SE: return isSE();
            case ICE: return isICE();
            case ROBOTICS: return isRobotics();
        }
        return false;
    }

    @Override
    public String toString() {
        return new Formatter()
                .format("Robotics: %b\n" +
                                "Informatics and Computer Engineering: %b\n" +
                                "Software Engineering: %b\n" +
                                "Full moon: %b\n" +
                                "Random: %b\n" +
                                "Amount of beer: %d\n",
                        robotics, ICE, SE, isFullMoon, isRandom, Beer.getInstance().getAmount())
                .toString();
    }
}