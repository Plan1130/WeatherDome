/*
 * WeatherDome!
 */
package weatherdomeproject;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MAX 'imaal' G
 */
public class WeatherType {
    private WeatherState state;

    
    int temperatureIntensity;
    int windIntensity;
    int cloudIntensity;
    int precipitationType;
    
    public WeatherType(WeatherState state) {
        this.state = state;
        this.setValues();
    }
    
    private void setValues() {
        setPrecipitationType();
        setWindType();
        setTemperatureType();
        setCloudType();
        
    }
    //type of rain: 0: no rain. 1: rain. 2: thunder. 3: snow.
    private void setPrecipitationType(){
        boolean isFreezing = false;
        boolean isRaining = false;
        boolean isThunder = false;
        
        if(state.getMinTemperature() < 1){
            isFreezing = true;
        }
        if(state.getPercipitationAmount() > 50){
            isRaining = true;
        }
        if(state.getMaxTemperature() > 250 && state.getPercipitationAmount() > 50){
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
    }
    //wind speed in 4 levels
    private void setWindType(){
        if(state.getMeanWindSpeed() < 30){
            windIntensity = 0;
        } else if(state.getMeanWindSpeed() >= 30 && state.getMeanWindSpeed() < 55){
            windIntensity = 1;
        } else if(state.getMeanWindSpeed() >= 55 && state.getMeanWindSpeed() <= 100){
            windIntensity = 2;
        } else if(state.getMeanWindSpeed() > 100){
            windIntensity = 3;
        }
    }
    //temperature in celcius, 
    private void setTemperatureType(){
        temperatureIntensity = (state.getMeanTemperature()/10);
    }
    
    //cloud amount in levels of 4
    private void setCloudType(){
        cloudIntensity = state.getCloudCover();
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
        builder.append("WeatherType Summary: \n");
        return builder.toString().replaceAll("-2147483648", "NULL");
    }
    
}
