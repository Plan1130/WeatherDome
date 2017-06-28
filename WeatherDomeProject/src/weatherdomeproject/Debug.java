/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 *
 * @author FlorianF
 */
public class Debug extends WeatherDomeProject {
    void test() {
        /*
        Testjens debugjens sectiones
        */
        
        //TEST MOGELIJKE INPUT VAN ARDUINO
        String arduinoteststring = "season=0&modifier=3&year=2016";

        currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        
        SceneSelector videomanager = new SceneSelector(obsTxtFile);
        
        videomanager.changeScene(currentWeatherState);
        
        System.exit(0);
    }
    
    static void log(String text) {
        System.out.println(text);
    }
}
