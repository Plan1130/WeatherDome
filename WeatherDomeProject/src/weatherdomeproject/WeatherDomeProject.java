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
    static final Database twentedb = new Database("datatwente.csv");
    
    /**
     * @param args the command line arguments stop die maar in je reet java
     */
    
    public static void main(String[] args) {
        twentedb.testRead();
        
    }
    
}
