/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

/**
 *
 * @author MA NIGGA
 */
public class WeatherDomeProject {
    //Databases are located in src/databases
    private static Database twentedb = new Database("datatwente.csv");
    private static WeatherState current;
    
    /**
     * @param args the command line arguments stop die maar in je reet java
     */
    
    public static void main(String[] args) {
        twentedb.getWeatherState(2016,1,1);
        
    }
    
}
