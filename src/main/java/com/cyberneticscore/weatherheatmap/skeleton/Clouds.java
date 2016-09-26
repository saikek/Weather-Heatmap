package com.cyberneticscore.weatherheatmap.skeleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clouds level - sunny or not
 * Created by saikek on 25.9.16.
 */

public enum Clouds {
    SUNNY, //Ясно
    SUNC, //Малооблачно
    SUNCL, //Облачно
    DULL; //Пасмурно

    private static final String pattern = "(\\w+)\\.png";
    private static final Pattern r = Pattern.compile(pattern);

    public static Clouds getCloudyLevel(String html) {
        final Matcher m = r.matcher(html);

        if (m.find()) {
            switch (m.group(1)) {
                case "sun": {
                    return Clouds.SUNNY;
                }
                case "sunc": {
                    return Clouds.SUNC;
                }
                case "suncl": {
                    return Clouds.SUNCL;
                }
                case "dull": {
                    return Clouds.DULL;
                }
            }
        }

        throw new IllegalArgumentException("Unknown clouds type: " + html);
    }
}