/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 *
 * @author FlorianF
 */
public class Future {
    int season;
    int modifier;
    
    public Future(int season, int modifier) {
        this.season = season;
        this.modifier = modifier;
    }
    
    public int getSeason() {
        return season;
    }
    
    public int getModifier() {
        return modifier;
    }
}
