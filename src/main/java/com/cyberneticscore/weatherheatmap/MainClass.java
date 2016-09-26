package com.cyberneticscore.weatherheatmap;

import java.io.IOException;

/**
 * Created by saikek on 25.9.16.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        WebParser wp = new WebParser();

        int Moskow = 4368;
        wp.extractYearWeather(Moskow, 2015);
    }


}
