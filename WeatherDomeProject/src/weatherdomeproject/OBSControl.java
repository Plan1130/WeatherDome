/*
 * WeatherDome!
 */
package weatherdomeproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Controls h4ck3d OBS
 * @author FlorianF
 */
public class OBSControl {
    private String txtFile;
    
    public OBSControl(String txtFile) {
        this.txtFile = txtFile;
    }
    
    public String getCurrentScene() {
        String line = null;
        try { 
            FileInputStream reader = new FileInputStream(txtFile);
            //System.out.println("Total file size to read (in bytes) : "+ reader.available());

			int content;
			while ((content = reader.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return line;
    }
    
    public void changeScene(String scene) {
        // Convert the string to a
        // byte array.
        scene = scene + '\n';
        byte data[] = scene.getBytes();
        try{
            FileOutputStream writer = new FileOutputStream(txtFile);
            writer.write(("").getBytes());
            writer.write(scene.getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
