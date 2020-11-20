package education.expulsion.config;

import beer.Beer;
import education.data.Faculty;

import java.util.Formatter;

public class ExpulsionConfig {

    private boolean isFullMoon;
    private boolean isRandom;
    private boolean robotics;
    private boolean ICE;
    private boolean SE;

    public ExpulsionConfig(boolean robotics,
                           boolean ICE,
                           boolean SE,
                           boolean isRandom,
                           boolean isFullMoon) {
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
    public boolean isRoboticsEnabled() {
        return robotics;
    }
    public boolean isICEEnabled() {
        return ICE;
    }
    public boolean isSEEnabled() {
        return SE;
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