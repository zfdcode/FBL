package com.tum.fbl.core.fitbit;

/**
 * Created by angusliu on 7/12/17.
 */
public class test {
    public static void main(String[]args){
        FitBitImpl Value1=new FitBitImpl("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1UTlZSE4iLCJhdWQiOiIyMjhGNkwiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJhY3QgcnNldCBybG9jIHJ3ZWkgcmhyIHJwcm8gcm51dCByc2xlIiwiZXhwIjoxNDk5MjkwMjc3LCJpYXQiOjE0OTkyNjE0Nzd9.uEb2PRGW58qxmjMx1gTqaG9YACPt5fo-Y6BHK9aj_D4");
        System.out.print(Value1.apiCall("https://api.fitbit.com/1/user/-/activities/goals/caloriesOut/daily.json").toString());
    }
}
