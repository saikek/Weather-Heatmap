package com.cyberneticscore.weatherheatmap.skeleton;

/**
 * Created by saikek on 25.9.16.
 */

public enum Clouds {
    SUNNY, //Ясно
    SUNC, //Малооблачно
    SUNCL, //Облачно
    DULL; //Пасмурно

    public static Clouds getCloudyLevel(String html) {
        if (html.contains("sun.png")) {
            return Clouds.SUNNY;
        }
        if (html.contains("sunc.png")) {
            return Clouds.SUNC;
        }
        if (html.contains("suncl.png")) {
            return Clouds.SUNCL;
        }
        if (html.contains("dull.png")) {
            return Clouds.DULL;
        }

        throw new IllegalArgumentException("Unknown clouds type: " + html);
    }
}