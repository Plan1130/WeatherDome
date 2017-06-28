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

public class WeatherDatabaseStruct {
    public static final int VOID = Integer.MIN_VALUE;
    
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
    
    public WeatherDatabaseStruct(int windDirection, int vectorWindSpeed, int meanWindSpeed, int meanTemperature, int minTemperature, int maxTemperature, int sunDuration, int sunPercentage, int globalRadiation, int percipitationDuration, int percipitationAmount, int minVisibility, int maxVisibility, int cloudCover, int humidity) {
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
        if (windDirection == VOID);
        return windDirection;
    }
    
    public int getVectorWindSpeed() {
        if (vectorWindSpeed == VOID);
        return vectorWindSpeed;
    }
    
    public int getMeanWindSpeed() {
        if (meanWindSpeed == VOID);
        return meanWindSpeed;
    }
    
    public int getMeanTemperature() {
        if (meanTemperature == VOID);
        return meanTemperature;
    }
    
    public int getMinTemperature() {
        if (minTemperature == VOID);
        return minTemperature;
    }

    public int getMaxTemperature() {
        if (maxTemperature == VOID);
        return maxTemperature;
    }

    public int getSunDuration() {
        if (sunDuration == VOID);
        return sunDuration;
    }

    public int getSunPercentage() {
        if (sunPercentage == VOID);
        return sunPercentage;
    }

    public int getGlobalRadiation() {
        if (globalRadiation == VOID);
        return globalRadiation;
    }

    public int getPercipitationDuration() {
        if (percipitationDuration == VOID);
        return percipitationDuration;
    }

    public int getPercipitationAmount() {
        if (percipitationAmount == VOID);
        return percipitationAmount;
    }

    public int getMinVisibility() {
        if (minVisibility == VOID);
        return minVisibility;
    }

    public int getMaxVisibility() {
        if (maxVisibility == VOID);
        return maxVisibility;
    }

    public int getCloudCover() {
        if (cloudCover == VOID);
        return cloudCover;
    }

    public int getHumidity() {
        if (humidity == VOID);
        return humidity;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WeatherState Summary: \n");
        builder.append("windDirection = " + windDirection + " | ");
        builder.append("vectorWindSpeed = " + vectorWindSpeed + " | ");
        builder.append("meanWindSpeed = " + meanWindSpeed + " | ");
        builder.append("meanTemperature = " + meanTemperature + " | ");
        builder.append("minTemperature = " + minTemperature + " | ");
        builder.append("maxTemperature = " + maxTemperature + " | ");
        builder.append("sunDuration = " + sunDuration + " | \n");
        builder.append("sunPercentage = " + sunPercentage + " | ");
        builder.append("globalRadiation = " + globalRadiation + " | ");
        builder.append("percipitationDuration = " + percipitationDuration + " | ");
        builder.append("percipitationAmount = " + percipitationAmount + " | ");
        builder.append("minVisibility = " + minVisibility + " | \n");
        builder.append("maxVisibility = " + maxVisibility + " | ");
        builder.append("cloudCover = " + cloudCover + " | ");
        builder.append("humidity = " + humidity + " | ");
        return builder.toString().replaceAll("-2147483648", "NULL");
    }    
}
