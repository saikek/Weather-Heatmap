package com.cyberneticscore.weatherheatmap.skeleton;

/**
 * Created by saikek on 25.9.16.
 */
public enum Events {
    RAIN,
    SNOW,
    THUNDER,
    NONE;

    public static Events getEvents(String html) {
        if (html.contains("rain.png")) {
            return Events.RAIN;
        }
        if (html.contains("snow.png")) {
            return Events.SNOW;
        }
        if (html.contains("storm.png")) {
            return Events.THUNDER;
        }
        throw new IllegalArgumentException("Unknown event: " + html);
    }
}
