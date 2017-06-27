/*
 * WeatherDome!
 */
package weatherdomeproject;

/**
 * Parses Arduino data and decides whether to go to the future, or database class
 * @author FlorianF
 */
public class ParseDecider {
    static int season;
    static int year;
    static int modifier;

    public static WeatherState parseData(String data, Database db) throws Exception{
        String[] splitis;
        String[] splitand;
        splitis = data.split("=");
        splitand = data.split("&");
        if (splitis.length == 4 && splitand.length == 3) {
            season = Integer.parseInt(splitis[1].split("&")[0]);
            year = Integer.parseInt(splitis[2].split("&")[0]);
            modifier = Integer.parseInt(splitis[3].split("&")[0]);
            return makeWeatherState(season,year,modifier,db);
        } else {
            throw new Exception("Verkeerde data uit die Arduino, mogool");
        }
    }
    
    private static WeatherState makeWeatherState(int season, int year, int modifier, Database db) {
        WeatherState weatherstate = null;
        //THE PAST
        if ((year == 2017 && season == 0) || (year <= 2016)) {
            //Maak een weatherstruct
            WeatherStruct weatherstruct;
            //Kies maand en dag
            int month = 0;
            int day = 0;
            switch (season) {
                case 0: //SPRING
                    month = 3;
                    day = 20;
                    break;
                case 1: //SUMMER
                    month = 6;
                    day = 21;
                    break;
                case 2: //AUTUMN
                    month = 9;
                    day = 22;
                    break;
                case 3: //WINTER
                    month = 12;
                    day = 21;
                    break;
            }
            try {
                weatherstruct = db.getWeatherStruct(year, month, day);
                weatherstate = new WeatherState(weatherstruct);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else { //THE FUTURE
            Future futurestruct = new Future(season, modifier);
            weatherstate = new WeatherState(futurestruct);
        }
        return weatherstate;
    }
}
