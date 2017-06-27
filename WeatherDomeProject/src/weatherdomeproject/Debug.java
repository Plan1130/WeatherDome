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
        String arduinoteststring = "22222season=1234&KRKERSANDERyear=2015234&JEMOEDERmodifier=1234234";

        currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
 
        //NOU WAT HEB JIJ GEKREGEN VAN PAPPA??
        log(currentWeatherState.toString());
    }
    
    void log(String text) {
        System.out.println(text);
    }
}
