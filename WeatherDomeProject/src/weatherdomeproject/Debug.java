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
        String arduinoteststring = "year=1995season=1modifier=1";

        try {
            currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        SceneSelector videomanager = new SceneSelector(obsTxtFile);
        
        videomanager.changeScene(currentWeatherState);
        
        twentedb.stressTest();
        
        System.exit(0);
    }
    
    static void log(String text) {
        System.out.println(text);
    }
}
