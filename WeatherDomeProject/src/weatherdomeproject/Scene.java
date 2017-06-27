/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 * FUCKIN SCENE so pro
 * @author FlorianF
 */
class Scene {
    protected String scenename;

    public String getScenename() {
        return scenename;
    }
}

class HistoryScene extends Scene {
    private int clouds;
    private int precipitation;
    private int season;

    public HistoryScene(String scenename, int cloud, int precipitation, int season) {
        super.scenename = scenename;
        this.clouds = cloud;
        this.precipitation = precipitation;
        this.season = season;
    }

    public int getClouds() {
        return clouds;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public int getSeason() {
        return season;
    }
}

class FutureScene extends Scene {
    private int modifier;

    public FutureScene (String scenenames, int modifier) {
        super.scenename = scenename;
        this.modifier = modifier;
    }
    
    public int getModifier() {
        return modifier;
    }
}