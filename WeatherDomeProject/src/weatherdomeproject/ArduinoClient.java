/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;
import java.io.IOException;
import okio.*;
import okhttp3.*;


/**
 *
 * @author FlorianF
 */
public class ArduinoClient {
    
    private final OkHttpClient client;
    
    public ArduinoClient() {
        client = new OkHttpClient();
    }
    
    public void PostData(String[] data, String url) {
        //POST DATA
        RequestBody formBody = new FormBody.Builder()
        .add(data[0], data[1])
        .add(data[2], data[3])
        .build();
        Request request = new Request.Builder()
        .url(url)
        .post(formBody)
        .build();
        
        try {
            Response response = client.newCall(request).execute();
            System.out.println( response.body().string() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    String GetData(String url) {
        String ret = "";
        
        Request request = new Request.Builder()
            .url(url)
            .build();

        try {
           Response response = client.newCall(request).execute();
           ret = response.body().string();
           System.out.println(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
    
    






/*      TESTJEN

        HttpUrl httpurl = new HttpUrl.Builder()
        .scheme("https")
        .host("www.google.com")
        .addPathSegment("search")
        .addQueryParameter("q", "polar bears")
        .build();
        
        Request r = new Request.Builder()
        .url(httpurl).build();
        
        try {
            Response response = client.newCall(r).execute();
            System.out.println( response.body().string() );
        } catch(Exception e) {
            e.printStackTrace();
        }
 
*/
