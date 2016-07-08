package com.example.ansal007.conflicto.config;

/**
 * Created by Ansal007 on 7/8/16.
 */
public class Config {

    private static Config config = null;

    public static Config getInstance(){
        if(config == null){
            config = new DevelopmentConfig();
        }
        return config;
    }

    Config() {
    }


    public String getBaseURL() {
        return null;
    }

    public String getSigninURL(){return this.getBaseURL() + "/user/signin" ;}

    public String getRegisterURL(){return this.getBaseURL()  + "/user/register";}



}
