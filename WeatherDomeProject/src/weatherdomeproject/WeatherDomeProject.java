/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author MA NIGGA
 */
public class WeatherDomeProject {
    //Databases are located in src/databases
    private static Database twentedb = new Database("datatwente.csv");
    //private static WeatherStruct weatherstruct;
    private static WeatherState currentWeatherState;
    private static ArduinoClient arduino;
    private static OBSControl videomanager;
    private final static String arduinoIP = "http://192.168.10.10";
    private final static String obsTxtFile = "C://dome.txt";
    
    /**
     * @param args the command line arguments maar in je reet java
     */
    
    public static void main(String[] args) {
        /*
        Testjens debugjens sectiones
        */
        
        //TEST MOGELIJKE INPUT VAN ARDUINO
        String arduinoteststring = "22222season=1234&KANKERSANDERyear=2015234&JEMOEDERmodifier=1234234";

        currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
 
        //NOU WAT HEB JIJ GEKREGEN VAN PAPPA??
        System.out.println(currentWeatherState.toString());
        
        
        /*
        * Serious final code below
        
        arduino = new ArduinoClient();
        videomanager = new OBSControl(obsTxtFile);
        String lastArduinoData = "";
        String currentArduinoData;
        
        while (true) {
            // GET data
            currentArduinoData = arduino.getData(arduinoIP);
            
            // Check if changed
            if (!currentArduinoData.equals(lastArduinoData)) {
                // Alter current state
                currentWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
 
                // If changed: POST new data
                //             Change video
               arduino.postData(arduinoIP, currentWeatherState.generateMap());
               videomanager.changeScene("Scene 2");
            }            
            
            
            // Sleep for a second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WeatherDomeProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
*/
    }
}
