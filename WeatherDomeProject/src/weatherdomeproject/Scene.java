/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 * FUCKIN SCENE so pro
 * @author FlorianF
 */
public abstract class Scene {
    protected String scenename;
    protected int clouds;
    protected int precipitation;
    protected int season;
    protected int modifier;
    
    public String getScenename() {
        return scenename;
    }
    
    public int getModifier() {
        return modifier;
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
    
    public String getTime() {
        return "Base";
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nScenename = " + getScenename() + "\n");
        builder.append("Modifier = " + getModifier() + "\n");
        builder.append("Clouds = " + getClouds() + "\n");
        builder.append("Precipitation = " + getPrecipitation() + "\n");
        builder.append("Season = " + getSeason() + "\n");
        builder.append("Time Occurance: " + getClass());
        return builder.toString();
    }
}

class HistoryScene extends Scene {
    public HistoryScene(String scenename, int cloud, int precipitation, int season) {
        super.scenename = scenename;
        super.clouds = cloud;
        super.precipitation = precipitation;
        super.season = season;
    }
    @Override
    public String getTime() {
        return "History";
    }
}

class FutureScene extends Scene {
    public FutureScene (String scenename, int modifier, int season) {
        super.scenename = scenename;
        super.modifier = modifier;
        super.season = season;
        //Voor false positives in de SceneSelector loop
        super.clouds = 4;
        super.precipitation = 4;
    }
    @Override
    public String getTime() {
        return "Future";
    }
}