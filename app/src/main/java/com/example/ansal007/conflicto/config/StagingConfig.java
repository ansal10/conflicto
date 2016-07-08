package com.example.ansal007.conflicto.config;

/**
 * Created by Ansal007 on 7/8/16.
 */
public class StagingConfig extends Config {

    private final String BASE_URL = "http://10.2.2.10:8000";

    @Override
    public String getBaseURL() {
        return BASE_URL;
    }
}
