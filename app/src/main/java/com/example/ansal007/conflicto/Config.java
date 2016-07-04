package com.example.ansal007.conflicto;

/**
 * Created by Ansal007 on 7/3/16.
 */
public class Config {

    private static Config config = null;
    private final String EMULATOR_DEV = "emdev";
    private final String DEVICE_DEV = "dev";
    private final String PRODUCTION = "prod";
    private String ENV ;

    private final String signinUrl = "/conflicto/login";


    public static Config getInstance(){
        if (config == null)
            config = new Config("dev");

        return config;
    }

    private Config(String ENV){
        this.ENV = ENV;
    }

    private String getHost(){
        switch (ENV) {
            case EMULATOR_DEV:
                return "10.0.2.2:8000";
            case DEVICE_DEV:
                return "3b33b321.ngrok.io";
            default:
                return "10.0.2.2";
        }
    }



    public String getSigninUrl() {
        return "http://"+getHost()+signinUrl;
    }
}
