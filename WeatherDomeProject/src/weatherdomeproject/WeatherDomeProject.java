/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

import javax.swing.SwingUtilities;


/**
 *
 * @author MA NIGGA
 */
public class WeatherDomeProject {
    //Databases are located in src/databases
    private static Database twentedb = new Database("datatwente.csv");
    private static WeatherState current;
    private static ArduinoClient arduino;
    private final static String arduinoIP = "http://192.168.10.10";
    
    /**
     * @param args the command line arguments maar in je reet java
     */
    
    public static void main(String[] args) {
        //START VIDEO
        //VideoPlayer vidplayer = new VideoPlayer();
        
        //START CLIENT
        arduino = new ArduinoClient();
        String[] data = {"test","5","test2","6"};
        arduino.PostData(data,arduinoIP);
        arduino.GetData(arduinoIP);
        
        
        
        
        //DATABASE CALL
        try {
            current = twentedb.getWeatherState(2000,1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(current.toString());

    }
    
}
