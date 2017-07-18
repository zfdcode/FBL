package com.tum.fbl.core.fitbit;

import com.tum.fbl.core.persistence.healthdata.HealthData;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.cloudinary.json.JSONObject;


import java.io.*;


public class FitBitImpl implements FitBit {
    private String token;

    public FitBitImpl(String token){
        this.token=token;
    }

    public String getsBurnedCaloriesValue () {
        JSONObject burnedCaloriesJson = new JSONObject(this.apiCall("https://api.fitbit.com/1/user/-/activities/tracker/calories/date/today/1d.json"));
        JSONObject oneDay = burnedCaloriesJson.getJSONArray("activities-tracker-calories").getJSONObject(0);
        String ret = oneDay.getString("value");
        return ret;
    }

    public String getsCalorieGoalValue () {
        JSONObject calorieGoalJson = new JSONObject(this.apiCall ("https://api.fitbit.com/1/user/-/activities/goals/daily.json"));
        JSONObject oneDay = calorieGoalJson.getJSONObject("goals");
        int ret = oneDay.getInt("caloriesOut");
        return Integer.toString(ret);
    }


    private String apiCall(String address) {

        CloseableHttpClient httpclient = HttpClients.createDefault();
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

