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
    private static ArduinoClient arduinopost;
    private static ArduinoClient arduinoget;
    private final static String arduinoIP = "192.168.10.10";
    
    /**
     * @param args the command line arguments maar in je reet java
     */
    
    public static void main(String[] args) {
        //START VIDEO
        //VideoPlayer vidplayer = new VideoPlayer();
        
        //START CLIENT
        arduinopost = new ArduinoClient();
        String[] data = {"test","5","test2","6"};
        arduinopost.PostData(data,arduinoIP);
        arduinopost.GetData(arduinoIP);
        
        
        
        
        //DATABASE CALL
        try {
            current = twentedb.getWeatherState(2000,1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(current.toString());

    }
    
}
