package com.cyberneticscore.weatherheatmap;

import java.io.IOException;

/**
 * Created by saikek on 25.9.16.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        WebParser wp = new WebParser();
        wp.parseYears(2013, 2014);
    }


}
