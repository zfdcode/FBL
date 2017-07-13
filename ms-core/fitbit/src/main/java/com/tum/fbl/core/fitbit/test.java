package com.tum.fbl.core.fitbit;

/**
 * Created by angusliu on 7/12/17.
 */

public class test {
    public static void main(String[]args){
        FitBitImpl Value1=new FitBitImpl("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1UTlZSE4iLCJhdWQiOiIyMjhGNkwiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJhY3QgcnNldCBybG9jIHJ3ZWkgcmhyIHJwcm8gcm51dCByc2xlIiwiZXhwIjoxNDk5OTkyMDMwLCJpYXQiOjE0OTk5NjMyMzB9.tj92anl8tZPoKYMFXpBmIXhEKM-_pgSYn_gbAYJOgeU");
        System.out.println(Value1.burnedCaloriesJson());
        System.out.println(Value1.calorieGoalJson());
    }
}
