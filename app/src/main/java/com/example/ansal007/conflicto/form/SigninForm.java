package com.example.ansal007.conflicto.form;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ansal007.conflicto.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.Callable;

/**
 * Created by Ansal007 on 7/3/16.
 */
public class SigninForm {

    private String username;
    private String password;
    private Config config = Config.getInstance();

    public SigninForm(String username, String password){
        this.username = username;
        this.password = password;
    }


}
