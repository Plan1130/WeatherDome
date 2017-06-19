/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

/**
 *
 * @author Sander
 */

public class WeatherState {
    private int windDirection;

    public int getWindDirection() {
        return windDirection;
    }
    public WeatherState(int windDirection) {
        this.windDirection = windDirection;
    }
}
