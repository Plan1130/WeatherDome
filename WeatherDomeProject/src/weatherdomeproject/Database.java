/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GITHUB
 * @author JoeyIsEenVirus.exe
 */

public class Database {
    
    private String databasename = "src/databases/";
    private FileReader filereader;
    private int totaldays;
    
    public Database(String filename) {
        databasename += filename;
        try {
            this.filereader = new FileReader(databasename);
            System.out.println("Database found!");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        try { 
            totaldays = countLines(databasename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void stressTest() {
        //Seek and destroy
        String read;
        String[] readArr;
        String[] foundData = null;
        
        BufferedReader reader = new BufferedReader(filereader);
        
        SceneSelector selector = new SceneSelector("C://dome.txt");
        
        for(int index = 0; index < totaldays; index++) {
            read = "";
            try {
                read = reader.readLine();
            } catch(Exception e) {
                
            }
            if (!read.equals("")) {
                readArr = read.split(",");
                List<Integer> editData = new ArrayList<>();
                foundData = readArr;

                for (String s : foundData) {
                    Debug.log(s);
                    if (s.equals("     ")) {
                        editData.add(WeatherDatabaseStruct.VOID);
                    } else {
                        editData.add(Integer.parseInt(s));
                    }                
                }
                
                //CHECK SEASON
                String date = readArr[0];
                Debug.log(date);
                char[] datearr = date.toCharArray();
                char[] month = {datearr[5], datearr[6]};
                char[] day = {datearr[6], datearr[7]};
                int maand = Integer.parseInt(new String(month));
                int dag = Integer.parseInt(new String(day));
                
                int season = 4;
                
                if ((maand <= 2 || (maand < 3 && dag <20)) || (maand == 12 && dag >= 21)) {
                    season = 0;
                } else if (maand <= 5 || (maand == 6 && dag < 21)) {
                    season = 1;
                } else if (maand <= 8 || (maand == 9 && dag < 22)) {
                    season = 2;
                } else if (maand <= 11 || (maand == 12 && dag < 21)) {
                    season = 3;
                }
                
                Debug.log(season + "");

                selector.changeScene(new HistoryWeatherState(new WeatherDatabaseStruct(editData.get(1), editData.get(2), editData.get(3), editData.get(4), editData.get(5)
                        , editData.get(6), editData.get(7), editData.get(8), editData.get(9), editData.get(10), editData.get(11)
                        , editData.get(12), editData.get(13), editData.get(14), editData.get(15)),season));

                try {
                    Thread.sleep(2500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WeatherDomeProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Debug.log("No data in this line");
            }
        }
    }
    
    public WeatherDatabaseStruct getWeatherStruct(int year, int month, int day) throws Exception {
        //Parse YYYYMMDD
        StringBuilder builder = new StringBuilder();
        //YYYY
        builder.append(year);
        //MM
        if (month < 10) {
            builder.append(0);
            builder.append(month);
        } else {
            builder.append(month);
        }
        //DD
        if (day < 10) {
            builder.append(0);
            builder.append(day);
        } else {
            builder.append(day);
        }
        int dateToFind = Integer.parseInt(builder.toString());
        
        //Seek and destroy
        String read;
        String[] readArr;
        String[] foundData = null;
        
        BufferedReader reader = new BufferedReader(filereader);
        
        for(int index = 0; index < totaldays; index++) {
            read = reader.readLine();
            readArr = read.split(",");
            if (Integer.parseInt(readArr[0]) == dateToFind) {
                //Found date
                foundData = readArr;
                break; //dubbelop
            }
        }
        
        if(foundData != null) {
            List<Integer> editData = new ArrayList<>();
            
            for (String s : foundData) {
                if (s.equals("     ")) {
                    editData.add(WeatherDatabaseStruct.VOID);
                } else {
                    editData.add(Integer.parseInt(s));
                }                
            }
            
            
            return new WeatherDatabaseStruct(editData.get(1), editData.get(2), editData.get(3), editData.get(4), editData.get(5)
                    , editData.get(6), editData.get(7), editData.get(8), editData.get(9), editData.get(10), editData.get(11)
                    , editData.get(12), editData.get(13), editData.get(14), editData.get(15));
            
        } else {
            throw new Exception("wtf denken jij");
        }        
    }
    
    
    public static int countLines(String filename) throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream(filename));
    try {
        byte[] c = new byte[1024];
        int count = 0;
        int readChars = 0;
        boolean empty = true;
        while ((readChars = is.read(c)) != -1) {
            empty = false;
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n') {
                    ++count;
                }
            }
        }
        return (count == 0 && !empty) ? 1 : count;
    } finally {
        is.close();
    }
}
}
