/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;



/**
 *
 * @author MA NIGGA
 */
public class WeatherDomeProject {
    //Databases are located in src/databases
    private static Database twentedb = new Database("datatwente.csv");
    private static WeatherState current;
    private static WeatherType weather;
    private static ArduinoClient arduino;
    private static OBSControl videomanager;
    private final static String arduinoIP = "http://192.168.10.10";
    private final static String obsTxtFile = "C://dome.txt";
    
    /**
     * @param args the command line arguments maar in je reet java
     */
    
    public static void main(String[] args) {
        
        //DEBUGGING WEATHER TYPE
        
        //Eerst data uit de database halen, in dit geval uit 19 januari 1993
        //wat vervolgens in current WeatherState struct wordt opgeslagen
        try {
            current = twentedb.getWeatherState(2015, 7, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(current.toString()); //DATA in current struct
        
        //Pass de current WeatherState naar de WeatherType class
        weather = new WeatherType(current);
        System.out.println(weather.toString());
        
        
        videomanager = new OBSControl(obsTxtFile);
        
        videomanager.getCurrentScene();
        
        videomanager.changeScene("Scene 2");
        
        /*
        * Serious final code below
        */
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
    
    }
}
