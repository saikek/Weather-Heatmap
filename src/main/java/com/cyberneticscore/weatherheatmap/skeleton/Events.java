package com.cyberneticscore.weatherheatmap.skeleton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Events, such as rain, snow, etc.
 * Created by saikek on 25.9.16.
 */
public enum Events {
    RAIN,
    SNOW,
    THUNDER,
    NONE;

    private static final String pattern = "(\\w+)\\.png";
    private static final Pattern r = Pattern.compile(pattern);

    public static Events getEvents(String html) {
        final Matcher m = r.matcher(html);

        if (m.find()) {
            switch (m.group(1)) {
                case "rain": {
                    return Events.RAIN;
                }
                case "snow": {
                    return Events.SNOW;
                }
                case "storm": {
                    return Events.THUNDER;
                }
            }
        }
        throw new IllegalArgumentException("Unknown event: " + html);
    }
}
