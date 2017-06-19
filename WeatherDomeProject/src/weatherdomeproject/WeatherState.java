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
    
    public int getWindDirection() throws ValueNotFoundException {
        if (windDirection == VOID) throw new ValueNotFoundException();
        return windDirection;
    }
    
    public int getVectorWindSpeed() throws ValueNotFoundException {
        if (vectorWindSpeed == VOID) throw new ValueNotFoundException();
        return vectorWindSpeed;
    }
    
    public int getMeanWindSpeed() throws ValueNotFoundException {
        if (meanWindSpeed == VOID) throw new ValueNotFoundException();
        return meanWindSpeed;
    }
    
    public int getMeanTemperature() throws ValueNotFoundException {
        if (meanTemperature == VOID) throw new ValueNotFoundException();
        return meanTemperature;
    }
    
    public int getMinTemperature() throws ValueNotFoundException {
        if (minTemperature == VOID) throw new ValueNotFoundException();
        return minTemperature;
    }

    public int getMaxTemperature() throws ValueNotFoundException {
        if (maxTemperature == VOID) throw new ValueNotFoundException();
        return maxTemperature;
    }

    public int getSunDuration() throws ValueNotFoundException {
        if (sunDuration == VOID) throw new ValueNotFoundException();
        return sunDuration;
    }

    public int getSunPercentage() throws ValueNotFoundException {
        if (sunPercentage == VOID) throw new ValueNotFoundException();
        return sunPercentage;
    }

    public int getGlobalRadiation() throws ValueNotFoundException {
        if (globalRadiation == VOID) throw new ValueNotFoundException();
        return globalRadiation;
    }

    public int getPercipitationDuration() throws ValueNotFoundException {
        if (percipitationDuration == VOID) throw new ValueNotFoundException();
        return percipitationDuration;
    }

    public int getPercipitationAmount() throws ValueNotFoundException {
        if (percipitationAmount == VOID) throw new ValueNotFoundException();
        return percipitationAmount;
    }

    public int getMinVisibility() throws ValueNotFoundException {
        if (minVisibility == VOID) throw new ValueNotFoundException();
        return minVisibility;
    }

    public int getMaxVisibility() throws ValueNotFoundException {
        if (maxVisibility == VOID) throw new ValueNotFoundException();
        return maxVisibility;
    }

    public int getCloudCover() throws ValueNotFoundException {
        if (cloudCover == VOID) throw new ValueNotFoundException();
        return cloudCover;
    }

    public int getHumidity() throws ValueNotFoundException {
        if (humidity == VOID) throw new ValueNotFoundException();
        return humidity;
    }
    
    public static class ValueNotFoundException extends Exception {
        public ValueNotFoundException(){
            super("Value not defined in database");
        }
    }
}
