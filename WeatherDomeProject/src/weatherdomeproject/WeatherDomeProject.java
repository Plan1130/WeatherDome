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
    private static WeatherState currWeatherState;
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
        String arduinoteststring = "season=2&year=2010&modifier=0";
        try {
            currWeatherState = ParseDecider.parseData(arduinoteststring, twentedb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //NOU WAT HEB JIJ GEKREGEN VAN PAPPA??
        System.out.println(currWeatherState.toString());
        
        
        
        //CLEANUP NEEDS TO BE DONE:
        videomanager = new OBSControl(obsTxtFile);
        
        videomanager.getCurrentScene();
        
        videomanager.changeScene("Scene 2");
        
        
        
        /*
        * Serious final code below
        
        arduino = new ArduinoClient();
        
        while (true) {
            // GET data
            String data = arduino.getData(arduinoIP);
            
            // Check if changed
            
            // Alter current state
            
            // If changed: POST new data
            //             Change video
            
            // Sleep for a second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WeatherDomeProject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //START CLIENT
//        arduino = new ArduinoClient();
//        String[] data = {"test","5","test2","6"};
//        arduino.PostData(data,arduinoIP);
//        arduino.GetData(arduinoIP);
    */
    }
}
