package com.tum.fbl.core.fitbit;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FitBitImpl implements FitBit {
    private String token;

    public void setToken(String token){ this.token = token; }

    public FitBitImpl(String token){
    this.token=token;
    }

    public String getBurnedCaloriesValue (){
        String json = this.burnedCalories();

    }

    public String burnedCalories () {
        String burnedCalories = this.apiCall("https://api.fitbit.com/1/user/-/activities/tracker/calories/date/today/1d.json");
        return (burnedCalories);
    }

    public String calorieGoal () {
        String calorieGoal = this.apiCall ("https://api.fitbit.com/1/user/-/activities/goals/daily.json");
        return (calorieGoal);
    }

    public String apiCall(String address) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
       // HttpGet httpget = new HttpGet("https://api.fitbit.com/1/user/-/activities/goals/caloriesOut/daily.json");
        HttpGet httpget = new HttpGet(address);
        httpget.setHeader("Authorization","Bearer "+token);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        }catch(IOException ioException){
        };
        HttpEntity entity = response.getEntity();
        String chunk="";
        InputStream inputStream = null;
        byte[] buffer = new byte[1024];
        if (entity != null) {
            try {
                inputStream = entity.getContent();
            }catch(IOException ioException){

            };
            try {
                int bytesRead = 0;
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                while ((bytesRead = bis.read(buffer)) != -1) {
                    chunk = new String(buffer, 0, bytesRead);
                    //System.out.println(chunk);
                }
            } catch (IOException ioException) {
                // In case of an IOException the connection will be released
                // back to the connection manager automatically
                ioException.printStackTrace();
            } catch (RuntimeException runtimeException) {
                // In case of an unexpected exception you may want to abort
                // the HTTP request in order to shut down the underlying
                // connection immediately.
                httpget.abort();
                runtimeException.printStackTrace();
            } finally {
                // Closing the input stream will trigger connection release
                try {
                    inputStream.close();
                } catch (Exception ignore) {
                }
            }

        }
        return (chunk);
    }


}


