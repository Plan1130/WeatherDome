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
    
    public SceneSelector(String obsfile, WeatherState weather) {
        obscontrol = new OBSControl(obsfile);
        scenes = new Scene[64];
        loadAllScenes();
    }
    
    private void loadAllScenes() {
        scenes[0] = new HistoryScene("clear sky spring",0,1,0);
        scenes[9] = new HistoryScene("clear sky summer",0,1,1);
        scenes[19] = new HistoryScene("clear sky autumn",0,1,2);
        scenes[29] = new HistoryScene("clear sky winter",0,1,3);
        scenes[42] = new FutureScene("no change",0);
        scenes[43] = new FutureScene("no meat",1);
        scenes[44] = new FutureScene("nuclear winter",2);
        scenes[45] = new FutureScene("no fossil fuels",3);

        scenes[45].getScenename();
        scenes[45].getModifier(); //HALP
    }
}
