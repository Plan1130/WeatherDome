/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * GITHUB
 * @author JoeyIsEenVirus.exe
 */

public class Database {
    
    private String databasename = "src/databases/";
    private FileReader filereader;
    
    public Database(String filename) {
        databasename += filename;
        try {
            this.filereader = new FileReader(databasename);
            System.out.println("Database found!");
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void testRead() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(filereader);
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] day = line.split(cvsSplitBy);

                System.out.println(day[0]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
