package education.expulsion.config;

import beer.Beer;

import java.util.Formatter;

/**
 * Класс-конфигурация. Было принято решение реализовать паттерн Builder, потому что класс имеет
 * Слишком много полей, а также потому что ни одно поле не обязано быть инициализировано вручную.
 * Это легче, чем создавать множество конструкторов для разных наборов параметров.
 */
public class ExpulsionConfig {

    private boolean isFullMoon;
    private boolean isRandom;
    private boolean robotics;
    private boolean ICE;
    private boolean SE;


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