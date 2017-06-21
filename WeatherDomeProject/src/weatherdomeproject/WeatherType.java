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
    rainIntensity rainType;
    enum rainIntensity {LOW,MEDIUM,HIGH};
    //this is blabaosi
    
    public WeatherType(WeatherState state) {
        this.state = state;
        this.setValues();
    }
    
    private void setValues() {
        isRaining = state.getPercipitationAmount() > 1 ? true : false;
        if (isRaining && state.getPercipitationAmount() < 10) {
            rainType = rainIntensity.LOW;
        } else if (state.getPercipitationAmount() > 10) {
            rainType = rainIntensity.MEDIUM;
        } else if (state.getPercipitationAmount() > 25) {
            rainType = rainIntensity.HIGH;
        }
        
        
    }
    
}
