import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FitBitImpl implements FitBit {
    private String token;

    public FitBitImpl(String token){
    this.token=token;
    }

    String a= this.apiCall("https://api.fitbit.com/1/user/-/activities/goals/caloriesOut/daily.json");


    private void apiCall(String address) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
       // HttpGet httpget = new HttpGet("https://api.fitbit.com/1/user/-/activities/goals/caloriesOut/daily.json");
        HttpGet httpget = new HttpGet(address);
        HttpGet.setHeader("Authorization","Beater "+token);
        CloseableHttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = HttpResponse.getEntity();
        byte[] buffer = new byte[1024];
        if (entity != null) {
            InputStream inputStream = entity.getContent();
            try {
                int bytesRead = 0;
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                while ((bytesRead = bis.read(buffer)) != -1) {
                    String chunk = new String(buffer, 0, bytesRead);
                    System.out.println(chunk);
                }
            } catch (IOException ioException) {
                // In case of an IOException the connection will be released
                // back to the connection manager automatically
                ioException.printStackTrace();
            } catch (RuntimeException runtimeException) {
                // In case of an unexpected exception you may want to abort
                // the HTTP request in order to shut down the underlying
                // connection immediately.
                HttpGet.abort();
                runtimeException.printStackTrace();
            } finally {
                // Closing the input stream will trigger connection release
                try {
                    inputStream.close();
                } catch (Exception ignore) {
                }
            }finally{
                response.close();
                return (entity);
            }
        }
    }



}


