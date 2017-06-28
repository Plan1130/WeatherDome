/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * The Weatherdome deception
 * @author MA NIGGA
 */
public class WeatherDomeProject {
    protected static Database twentedb = new Database("datatwente.csv");
    protected static WeatherState currentWeatherState;
    protected static ArduinoClient arduino;
    protected final static String arduinoIP = "http://192.168.10.10";
    protected final static String obsTxtFile = "C://dome.txt";
    
    /**
     * @param args the command line arguments maar in je reet java
     */
    
    public static void main(String[] args) {
        new Debug().test();
        
        /*
        * Serious final code below
        */
        arduino = new ArduinoClient();
        SceneSelector videomanager = new SceneSelector(obsTxtFile);
        String lastArduinoData = "";
        String currentArduinoData;
        
        while (true) {
            // GET data
            currentArduinoData = arduino.getData(arduinoIP);
            
            // Check if changed
            if (!currentArduinoData.equals(lastArduinoData)) {
                // Save last state fool
                lastArduinoData = currentArduinoData;
                // Alter current state
                currentWeatherState = ParseDecider.parseData(currentArduinoData, twentedb);
 
                // If changed: POST new data
                //             Change video
               arduino.postData(arduinoIP, currentWeatherState.generateMap());
               videomanager.changeScene(currentWeatherState);
            }            
            
            // Sleep for a second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WeatherDomeProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
