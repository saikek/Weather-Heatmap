package com.cyberneticscore.weatherheatmap;

import com.cyberneticscore.weatherheatmap.skeleton.Events;
import com.cyberneticscore.weatherheatmap.skeleton.WeatherEntry;
import com.cyberneticscore.weatherheatmap.skeleton.Wind;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

import static com.cyberneticscore.weatherheatmap.skeleton.Clouds.getCloudyLevel;

/**
 * Main parser class
 * Created by saikek on 25.9.16.
 */
public class WebParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebParser.class);
    private static final String userAgent = "Mozilla/5.0 (X11; U; Linux i586; en-US; rv:1.7.3) Gecko/20040924 Epiphany/1.4.4 (Ubuntu)";
    private static final String urlPrefix = "http://www.gismeteo.ru/diary/";

    void extractYearWeather(int cityId, int starYear, int endYear) throws IOException {
        for (int year = starYear; year < endYear; year++) {
            extractYearWeather(cityId, year);
        }
    }

    ArrayList<ArrayList<WeatherEntry>> extractYearWeather(int cityId, int year) throws IOException {
        ArrayList<ArrayList<WeatherEntry>> yearWeather = new ArrayList<>();
        for (int month = 1; month < 12 + 1; month++) {
            String url = urlPrefix + cityId + "/" + year + "/" + month + "/";

            yearWeather.add(extractDataForMonth(url, true));
            break;
        }
        return yearWeather;
    }

    ArrayList<WeatherEntry> extractDataForMonth(String url, boolean dayOrNight) throws IOException {
        Document doc = Jsoup.connect(url).userAgent(userAgent)
                .timeout(10 * 1000)
                .get();

        Element table = doc.getElementById("data_block").child(2);

        ArrayList<WeatherEntry> monthWeather = new ArrayList<>();

        for (Element row : table.select("tr")) {
            Elements tds = row.select("td");
            if (tds.size() > 0) {
                int day = Integer.parseInt(tds.get(0).text());

                WeatherEntry weather;

                if (dayOrNight) {
                    weather = new WeatherEntry(
                            day,
                            Integer.parseInt(tds.get(1).text()),
                            Integer.parseInt(tds.get(2).text()),
                            getCloudyLevel(tds.get(3).child(0).toString()),
                            parseEvents(tds.get(4)),
                            Wind.getWind(tds.get(5).text()));
                } else {
                    weather = new WeatherEntry(
                            day,
                            Integer.parseInt(tds.get(6).text()),
                            Integer.parseInt(tds.get(7).text()),
                            getCloudyLevel(tds.get(8).child(0).toString()),
                            parseEvents(tds.get(9)),
                            Wind.getWind(tds.get(10).text()));
                }

                monthWeather.add(weather);
            }
        }
        return monthWeather;
    }

    Events parseEvents(Element row) {
        if (row.html().isEmpty()) {
            return Events.NONE;
        } else {
            return Events.getEvents(row.child(0).toString());
        }
    }
}
