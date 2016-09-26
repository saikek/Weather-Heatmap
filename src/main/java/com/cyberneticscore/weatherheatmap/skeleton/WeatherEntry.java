package com.cyberneticscore.weatherheatmap.skeleton;

/**
 * Weather Entry - complete table elements
 * Created by saikek on 25.9.16.
 */
public class WeatherEntry {
    String separator = ",";


    private int day;
    private int temperature;
    private int pressure;
    private Clouds cloudy;
    private Events events;
    private Wind wind;

    public WeatherEntry(int day,
                        int temperature, int pressure,
                        Clouds cloudy, Events events,
                        Wind wind) {
        this.day = day;
        this.temperature = temperature;
        this.pressure = pressure;
        this.cloudy = cloudy;
        this.events = events;
        this.wind = wind;
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(day).append(separator);
        sb.append(temperature).append(separator);
        sb.append(pressure).append(separator);
        sb.append(cloudy.ordinal()).append(separator); //TODO
        sb.append(events.ordinal()).append(separator);
        sb.append(wind);
        return sb.toString();
    }
}
