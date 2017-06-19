/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

/**
 *
 * @author Sander
 */

public class WeatherState {
    private final int windDirection;
    private final int vectorWindSpeed;
    private final int meanWindSpeed;
    private final int meanTemperature;
    private final int minTemperature;
    private final int maxTemperature;
    private final int sunDuration;
    private final int sunPercentage;
    private final int globalRadiation;
    private final int percipitationDuration;
    private final int percipitationAmount;
    private final int minVisibility;
    private final int maxVisibility;
    private final int cloudCover;
    private final int humidity;

    public WeatherState(int windDirection, int vectorWindSpeed, int meanWindSpeed, int meanTemperature, int minTemperature, int maxTemperature, int sunDuration, int sunPercentage, int globalRadiation, int percipitationDuration, int percipitationAmount, int minVisibility, int maxVisibility, int cloudCover, int humidity) {
        this.windDirection = windDirection;
        this.vectorWindSpeed = vectorWindSpeed;
        this.meanWindSpeed = meanWindSpeed;
        this.meanTemperature = meanTemperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.sunDuration = sunDuration;
        this.sunPercentage = sunPercentage;
        this.globalRadiation = globalRadiation;
        this.percipitationDuration = percipitationDuration;
        this.percipitationAmount = percipitationAmount;
        this.minVisibility = minVisibility;
        this.maxVisibility = maxVisibility;
        this.cloudCover = cloudCover;
        this.humidity = humidity;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public int getVectorWindSpeed() {
        return vectorWindSpeed;
    }

    public int getMeanWindSpeed() {
        return meanWindSpeed;
    }

    public int getMeanTemperature() {
        return meanTemperature;
    }

    public int getMinTemperature() {
        return minTemperature;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public int getSunDuration() {
        return sunDuration;
    }

    public int getSunPercentage() {
        return sunPercentage;
    }

    public int getGlobalRadiation() {
        return globalRadiation;
    }

    public int getPercipitationDuration() {
        return percipitationDuration;
    }

    public int getPercipitationAmount() {
        return percipitationAmount;
    }

    public int getMinVisibility() {
        return minVisibility;
    }

    public int getMaxVisibility() {
        return maxVisibility;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public int getHumidity() {
        return humidity;
    }
}
