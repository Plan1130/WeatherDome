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
        SceneSelector videomanager = new SceneSelector(obsTxtFile);
        
        //TEST MOGELIJKE INPUT VAN ARDUINO
        String arduinoteststring = "year=1988season=1modifier=1";

        try {
            currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        videomanager.changeScene(currentWeatherState);
        
        arduinoteststring = "year=1978season=1modifier=1";

        try {
            currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        arduinoteststring = "year=2978season=1modifier=1";

        try {
            currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        arduinoteststring = "year=2978season=2modifier=3";

        try {
            currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        videomanager.changeScene(currentWeatherState);
        
        twentedb.stressTest();
        
        System.exit(0);
    }
    
    static void log(String text) {
        System.out.println(text);
    }
}
