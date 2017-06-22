/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 *
 * @author MAX 'imaal' G
 */
public class WeatherType {
    private WeatherState state;
    boolean isRaining;
    boolean isSnowing;
    rainIntensity rainType;
    windIntensity windType;
    temperatureIntensity temperatureType;
    enum rainIntensity {NONE,LOW,MEDIUM,HIGH};
    enum windIntensity {LOW,MEDIUM,HIGH};
    enum temperatureIntensity {FREEZE,COLD,WARM,HOT};
    //this is blabaosi
    
    public WeatherType(WeatherState state) {
        this.state = state;
        this.setValues();
    }
    
    private void setValues() {
        setRainType();
        setWindType();
        setTemperatureType();
        checkForSnow();
        
    }
    private void setRainType(){
        isRaining = state.getPercipitationAmount() > 1 ? true : false;
        
        
        if (isRaining && state.getPercipitationAmount() < 10) {
            rainType = rainIntensity.LOW;
        } else if (state.getPercipitationAmount() > 10) {
            rainType = rainIntensity.MEDIUM;
        } else if (state.getPercipitationAmount() > 25) {
            rainType = rainIntensity.HIGH;
        } else if(!isRaining){
            rainType = rainIntensity.NONE;
        }
    }
    private void setWindType(){
        if(state.getMeanWindSpeed() < 55){
            windType = windIntensity.LOW;
        } else if(state.getMeanWindSpeed() >= 55 && state.getMeanWindSpeed() <= 100){
            windType = windIntensity.MEDIUM;
        } else if(state.getMeanWindSpeed() > 100){
            windType = windIntensity.HIGH;
        }
    }
    private void setTemperatureType(){
        if(state.getMaxTemperature() <= 0){
            temperatureType = temperatureIntensity.FREEZE;
        } else if(state.getMaxTemperature() > 0 && state.getMaxTemperature() <= 150){
            temperatureType = temperatureIntensity.COLD;
        } else if(state.getMaxTemperature() > 150 && state.getMaxTemperature() <= 250){
            temperatureType = temperatureIntensity.WARM;
        } else if(state.getMaxTemperature() > 250){
            temperatureType = temperatureIntensity.HOT;
        }
    }
    private void checkForSnow(){
        isSnowing = false;
        System.out.println(isRaining);
        System.out.println(state.getMinTemperature() < 0);
        if(isRaining && state.getMinTemperature() < 0){
            isSnowing = true;
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WeatherType Summary: \n");
        builder.append("rainType = " + rainType + " | ");
        builder.append("windType = " + windType + " | ");
        builder.append("temperatureType = " + temperatureType + " | ");
        builder.append("is Snowing = " + isSnowing + " | ");
        return builder.toString().replaceAll("-2147483648", "NULL");
    }
    
}
