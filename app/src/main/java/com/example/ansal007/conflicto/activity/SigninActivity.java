package com.example.ansal007.conflicto.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ansal007.conflicto.Config;
import com.example.ansal007.conflicto.R;
import com.example.ansal007.conflicto.form.SigninForm;

import org.json.JSONException;
import org.json.JSONObject;

import static android.widget.Toast.LENGTH_SHORT;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SIGNIN_URL = "http://10.0.2.2:8000/polls/test";
    private final Config config = Config.getInstance();
    private  RequestQueue requestQueue ;
    private Button signinButton = null;
    private Button gotoRegisterButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        signinButton = (Button) findViewById(R.id.signinButton);
        gotoRegisterButton = (Button) findViewById(R.id.gotoRegisterButton);
        signinButton.setOnClickListener(this);
        gotoRegisterButton.setOnClickListener(this);
        requestQueue = Volley.newRequestQueue(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.signinButton) {
            String username = ((EditText)findViewById(R.id.usernameText)).getText().toString();
            String password = ((EditText)findViewById(R.id.passwordText)).getText().toString();
            doSignin(username, password);
        }
    }

    private void doSignin(String username, String password) {
        JSONObject requestObj = new JSONObject();
        try {
            requestObj.put("username", username);
            requestObj.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("XXX", e.getMessage());
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, config.getSigninUrl(), requestObj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        signinResponseHandler(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SigninActivity.this, "Cannot connect to our servers", LENGTH_SHORT).show();
                    }
                });

        requestQueue.add(jsonObjectRequest);

    }

    private void signinResponseHandler(JSONObject response) {
        try {
            Boolean success = response.getBoolean("success");
            if (success){
                Toast.makeText(this, "Successfully login, will start new activity", LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
            }else {
                int errorCode = response.getJSONObject("error").getInt("code");
                String message = response.getJSONObject("error").getString("message");
                String text = "Error code : "+errorCode + "\n" + message;
                Toast.makeText(this, text, LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "There was an issue while logging in ", LENGTH_SHORT).show();
        }
    }

}
