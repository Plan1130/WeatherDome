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
public class WeatherState {
    private WeatherStruct state;
    private Future future;

    
    int temperatureIntensity;
    int windIntensity;
    int cloudIntensity;
    int precipitationType;
    
    public WeatherState(WeatherStruct state) {
        this.state = state;
        this.setPastValues();
    }
    
    public WeatherState(Future future) {
        this.future = future;
        this.setFutureValues();
    }
    
    private void setPastValues() {
        setPrecipitationType();
        setWindType();
        setTemperatureType();
        setCloudType();
    }
    
    private void setFutureValues() {
        switch(future.getModifier()) {
            case 0: //NO CHANGE
                temperatureIntensity = 40;
                windIntensity = 3;
                cloudIntensity = 3;
                precipitationType = 2;
                break;
            case 1: //NO MEAT
                temperatureIntensity = 0;
                windIntensity = 2;
                cloudIntensity = 1;
                precipitationType = 3;
                break;
            case 2: //NUCLEAR WINTER
                temperatureIntensity = 10;
                windIntensity = 0;
                cloudIntensity = 0;
                precipitationType = 0;
                break;
            case 3: //NO FOSSIL FUEL
                temperatureIntensity = 20;
                windIntensity = 3;
                cloudIntensity = 3;
                precipitationType = 1;
                break;
        }
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
        builder.append("WeatherState Summary: \n");
        builder.append("\nTemperature Intensity: " + temperatureIntensity);
        builder.append("\nWind Intensity: " + windIntensity);
        builder.append("\nCloud Intensity: " + cloudIntensity);
        builder.append("\nPrecipitation Type: " + precipitationType); //TODO: ADD TEXTUAL TYPE OUTPUT
        return builder.toString().replaceAll("-2147483648", "NULL");
    }
    
}
