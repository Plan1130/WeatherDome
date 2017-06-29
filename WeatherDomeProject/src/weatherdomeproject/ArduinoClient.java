/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdomeproject;
import java.io.IOException;
import java.util.Map;
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
    
    public void postData(String url, final Map<String, String> map) {
        //POST DATA
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (final Map.Entry<String, String> entrySet : map.entrySet()) {
            formBodyBuilder.add(entrySet.getKey(), entrySet.getValue());
            Debug.log(entrySet.getKey() + ", " + entrySet.getValue());
        }
        FormBody formBody = formBodyBuilder.build();
        
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
    
    public String getData(String url) {
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
