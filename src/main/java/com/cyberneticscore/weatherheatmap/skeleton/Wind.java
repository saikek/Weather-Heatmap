package com.cyberneticscore.weatherheatmap.skeleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Wind with direction and power
 * Created by saikek on 26.9.16.
 */
enum Direction {
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST,
    UNDEFINED
}

public class Wind {
    Direction direction;
    int power;

    private static final String pattern = "([А-Я]+)?\\s(\\d+)";

    private static final Pattern r = Pattern.compile(pattern);

    public Wind(Direction direction, int power) {
        this.direction = direction;
        this.power = power;
    }

    public static Wind getWind(String toParse) {
        Matcher m = r.matcher(toParse);

        if (m.find()) {
            Direction direction = getDirection(m.group(1));
            int power = Integer.parseInt(m.group(2));

            return new Wind(direction, power);
        }

        final String noDirectionPattern = "(\\d+)м/с";
        final Pattern rNoDir = Pattern.compile(noDirectionPattern);

        m = rNoDir.matcher(toParse);

        if (m.find()){
            int power = Integer.parseInt(m.group(1));

            return new Wind(Direction.UNDEFINED, power);
        }

        throw new IllegalArgumentException("Unable to parse wind string: " + toParse);
    }

    private static Direction getDirection(String directionString) {
        switch (directionString) {
            case "С": {
                return Direction.NORTH;
            }
            case "СВ": {
                return Direction.NORTH_EAST;
            }
            case "В": {
                return Direction.EAST;
            }
            case "ЮВ": {
                return Direction.SOUTH_EAST;
            }
            case "Ю": {
                return Direction.SOUTH;
            }
            case "ЮЗ": {
                return Direction.SOUTH_WEST;
            }
            case "З": {
                return Direction.WEST;
            }
            case "СЗ": {
                return Direction.NORTH_WEST;
            }
            default: {
                throw new IllegalArgumentException("Unknown wind direction: "
                        + directionString);
            }
        }
    }

    @Override public String toString() {
        return direction + " " + power;
    }
}
