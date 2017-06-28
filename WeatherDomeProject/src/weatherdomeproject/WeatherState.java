/*
 * WeatherDome!
 */
package weatherdomeproject;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author FlorianF
 */
public abstract class WeatherState {
    protected int temperatureIntensity; 
    protected int windIntensity;
    protected int cloudIntensity; //LED AANGESTUURD DOOR DEZE XXX CHRIS VERMAAS
    protected int precipitationType;
    protected int season;
    protected int modifier;
    
    public int getTempIntensity() {
        return temperatureIntensity;
    }
    
    public int getWindIntensity() {
        return windIntensity;
    }
    
    public int cloudIntensity() {
        return cloudIntensity;
    }
    
    public int getPrecipitation() {
        return precipitationType;
    }
    
    public int getSeason() {
        return season;
    }
    
    public int getModifier() {
        return modifier;
    }
    
    public String getTime() {
        return "Base";
    }
    
    public Map<String, String> generateMap(){
        Map<String, String> map = new HashMap<>();
        map.put("temperature", Integer.toString(temperatureIntensity));
        map.put("wind", Integer.toString(windIntensity));
        map.put("clouds", Integer.toString(cloudIntensity));
        map.put("percipitation", Integer.toString(precipitationType));
        return map;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nWeatherState Summary: \n");
        builder.append("Temperature Intensity: " + temperatureIntensity);
        builder.append("\nWind Intensity: " + windIntensity);
        builder.append("\nCloud Intensity: " + cloudIntensity);
        builder.append("\nPrecipitation Type: " + precipitationType);
        builder.append("\nSeason: " + season);
        builder.append("\nModifier: " + modifier);
        builder.append("\nTime Occurance: " + getClass());
        return builder.toString();
        //TODO: ADD TEXTUAL TYPE OUTPUT
    }
}

class HistoryWeatherState extends WeatherState {
    HistoryWeatherState(WeatherDatabaseStruct weatherstruct, int season) {
        super.season = season;
        determineWeather(weatherstruct);
    }
    
    private void determineWeather(WeatherDatabaseStruct struct) {
        //type of rain: 0: no rain. 1: rain. 2: thunder. 3: snow.
        boolean isFreezing = false;
        boolean isRaining = false;
        boolean isThunder = false;
        
        if(struct.getMinTemperature() < 1){
            isFreezing = true;
        }
        if(struct.getPercipitationAmount() > 50){
            isRaining = true;
        }
        if(struct.getMaxTemperature() > 200 && struct.getPercipitationAmount() > 50){
            Debug.log("ONWEER!!!!");
            isThunder = true;
        }
        
        if(!isRaining){
            precipitationType = 0; //no rain
        }
        if(isRaining && !isFreezing && !isThunder){
            precipitationType = 1; //is rain
        }
        if(isThunder){
            precipitationType = 2; //is thunder
        }
        if(isRaining && isFreezing && !isThunder){
            precipitationType = 3; //is snowing
        }

        //wind speed in 4 levels
        if(struct.getMeanWindSpeed() < 30){
            windIntensity = 0;
        } else if(struct.getMeanWindSpeed() >= 30 && struct.getMeanWindSpeed() < 55){
            windIntensity = 1;
        } else if(struct.getMeanWindSpeed() >= 55 && struct.getMeanWindSpeed() <= 100){
            windIntensity = 2;
        } else if(struct.getMeanWindSpeed() > 100){
            windIntensity = 3;
        }

        //temperature in celcius, 
        temperatureIntensity = (struct.getMeanTemperature()/10);
    
        //cloud amount in levels of 4
        cloudIntensity = struct.getCloudCover();
        if(cloudIntensity < 2){
            cloudIntensity = 0;
        }else if(cloudIntensity >= 2 && cloudIntensity < 4){
            cloudIntensity = 1;
        }else if(cloudIntensity >= 4 && cloudIntensity < 6){
            cloudIntensity = 2;
        }else if(cloudIntensity >= 6 && cloudIntensity < 9){
            cloudIntensity = 3;
        }
    }
    
    @Override
    public String getTime() {
        return "History";
    }
}

class FutureWeatherState extends WeatherState {
    FutureWeatherState(int modifier, int season) {
        super.modifier = modifier;
        super.season = season;
        determineWeather(modifier);
    }
    
    private void determineWeather(int modifier) {
        switch(modifier) {
            case 0: //NO CHANGE
                super.temperatureIntensity = 40;
                super.windIntensity = 3;
                super.cloudIntensity = 3;
                super.precipitationType = 2;
                break;
            case 1: //NO MEAT
                super.temperatureIntensity = 0;
                super.windIntensity = 2;
                super.cloudIntensity = 1;
                super.precipitationType = 3;
                break;
            case 2: //NUCLEAR WINTER
                super.temperatureIntensity = 10;
                super.windIntensity = 0;
                super.cloudIntensity = 0;
                super.precipitationType = 0;
                break;
            case 3: //NO FOSSIL FUEL
                super.temperatureIntensity = 20;
                super.windIntensity = 3;
                super.cloudIntensity = 3;
                super.precipitationType = 1;
                break;
        }
    }
    @Override
    public String getTime() {
        return "Future";
    }
}