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
    
    public WeatherStruct getWeatherStruct(int year, int month, int day) throws Exception {
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
                    editData.add(WeatherStruct.VOID);
                } else {
                    editData.add(Integer.parseInt(s));
                }                
            }
            
            
            return new WeatherStruct(editData.get(1), editData.get(2), editData.get(3), editData.get(4), editData.get(5)
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
