/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 *
 * @author FlorianF
 */
public class SceneSelector {
    private String currScene;
    private Scene[] scenes;
    private WeatherState weather;
    private static OBSControl obscontrol;
    
    public SceneSelector(String obsfile) {
        obscontrol = new OBSControl(obsfile);
        scenes = new Scene[59];
        loadAllScenes();
    }
    
    public void changeScene(WeatherState weather) {
        
        for (int i = 0; i < scenes.length ; i++) {
           // Debug.log(weather.getTime() + " EN DE SCENE CLASS " + scene.getTime());
            if (weather.getTime().equals(scenes[i].getTime()) && weather.cloudIntensity()== scenes[i].getClouds() &&
                    weather.getPrecipitation() == scenes[i].getPrecipitation() &&
                    weather.getSeason() == scenes[i].getSeason()) {
                obscontrol.changeScene("Scene "+i); //FOUND CHANGE SCENE
                Debug.log("Found HISTORY scene: \n" + scenes[i].toString() + "\nCorresponding to weatherstate: \n" + weather.toString());
                break;
            } else if (weather.getTime().equals(scenes[i].getTime()) && weather.getModifier() == scenes[i].getModifier() && weather.getSeason() == scenes[i].getSeason()) {
                obscontrol.changeScene("Scene "+i); //FOUND CHANGE SCENE
                Debug.log("Found FUTURE scene: \n" + scenes[i].toString() + "\nCorresponding to weatherstate: \n" + weather.toString());
                break;
            }
        }
    }
    
    private void loadAllScenes() {
        //String scenename, int cloud, int precipitation, int season
        //SPRING
        scenes[0] = new HistoryScene("spring clear sky",0,0,0);
        scenes[1] = new HistoryScene("spring little clouds no rain",1,0,0);
        scenes[2] = new HistoryScene("spring Little clouds, rain",1,1,0);
        scenes[3] = new HistoryScene("spring Little clouds, thunder",1,2,0);
        scenes[4] = new HistoryScene("spring Medium clouds, no rain",2,0,0);
        scenes[5] = new HistoryScene("spring Medium clouds, rain",2,1,0);
        scenes[6] = new HistoryScene("spring Medium clouds, thunder",2,2,0);
        scenes[7] = new HistoryScene("spring Heavy clouds, no rain",3,0,0);
        scenes[8] = new HistoryScene("spring Heavy clouds, rain",3,1,0);
        scenes[9] = new HistoryScene("spring Heavy clouds, thunder",3,2,0);
        
        //SUMMER
        scenes[10] = new HistoryScene("summer clear sky",0,0,1);
        scenes[11] = new HistoryScene("summer little clouds no rain",1,0,1);
        scenes[12] = new HistoryScene("summer Little clouds, rain",1,1,1);
        scenes[13] = new HistoryScene("summer Little clouds, thunder",1,2,1);
        scenes[14] = new HistoryScene("summer Medium clouds, no rain",2,0,1);
        scenes[15] = new HistoryScene("summer Medium clouds, rain",2,1,1);
        scenes[16] = new HistoryScene("summer Medium clouds, thunder",2,2,1);
        scenes[17] = new HistoryScene("summer Heavy clouds, no rain",3,0,1);
        scenes[18] = new HistoryScene("summer Heavy clouds, rain",3,1,1);
        scenes[19] = new HistoryScene("summer Heavy clouds, thunder",3,2,1);
        
        //AUTUMN
        scenes[20] = new HistoryScene("autumn clear sky",0,0,2);
        scenes[21] = new HistoryScene("autumn little clouds no rain",1,0,2);
        scenes[22] = new HistoryScene("autumn Little clouds, rain",1,1,2);
        scenes[23] = new HistoryScene("autumn Little clouds, thunder",1,2,2);
        scenes[24] = new HistoryScene("autumn Medium clouds, no rain",2,0,2);
        scenes[25] = new HistoryScene("autumn Medium clouds, rain",2,1,2);
        scenes[26] = new HistoryScene("autumn Medium clouds, thunder",2,2,2);
        scenes[27] = new HistoryScene("autumn Heavy clouds, no rain",3,0,2);
        scenes[28] = new HistoryScene("autumn Heavy clouds, rain",3,1,2);
        scenes[29] = new HistoryScene("autumn Heavy clouds, thunder",3,2,2);
        
        //WINTER
        scenes[30] = new HistoryScene("winter clear sky",0,0,3);
        scenes[31] = new HistoryScene("winter little clouds no rain",1,0,3);
        scenes[32] = new HistoryScene("winter Little clouds, rain",1,1,3);
        scenes[33] = new HistoryScene("winter Little clouds, thunder",1,2,3);
        scenes[34] = new HistoryScene("winter Medium clouds, no rain",2,0,3);
        scenes[35] = new HistoryScene("winter Medium clouds, rain",2,1,3);
        scenes[36] = new HistoryScene("winter Medium clouds, thunder",2,2,3);
        scenes[37] = new HistoryScene("winter Heavy clouds, no rain",3,0,3);
        scenes[38] = new HistoryScene("winter Heavy clouds, rain",3,1,3);
        scenes[39] = new HistoryScene("winter Heavy clouds, thunder",3,2,3);
        //SNOWSCENES WINTER
        scenes[40] = new HistoryScene("winter Little clouds, snow",1,3,3);
        scenes[41] = new HistoryScene("winter Medium clouds, snow",2,3,3);
        scenes[42] = new HistoryScene("winter Heavy clouds, snow",3,3,3);
        
        //FUTURE
        //NO CHANGE
        scenes[43] = new FutureScene("no change spring",0,0);
        scenes[44] = new FutureScene("no change summer",0,1);
        scenes[45] = new FutureScene("no change autumn",0,2);
        scenes[46] = new FutureScene("no change winter",0,3);
        //NO MEAT
        scenes[47] = new FutureScene("no meat spring",1,0);
        scenes[48] = new FutureScene("no meat summer",1,1);
        scenes[49] = new FutureScene("no meat autumn",1,2);
        scenes[50] = new FutureScene("no meat winter",1,3);
        //NUCLEAR WINTER
        scenes[51] = new FutureScene("nuclear winter spring",2,0);
        scenes[52] = new FutureScene("nuclear winter summer",2,1);
        scenes[53] = new FutureScene("nuclear winter autumn",2,2);
        scenes[54] = new FutureScene("nuclear winter winter",2,3);
        //GREEN ENERGY
        scenes[55] = new FutureScene("no fossil fuels spring",3,0);
        scenes[56] = new FutureScene("no fossil fuels summer",3,1);
        scenes[57] = new FutureScene("no fossil fuels autumn",3,2);
        scenes[58] = new FutureScene("no fossil fuels winter",3,3);        
    }
    
}
