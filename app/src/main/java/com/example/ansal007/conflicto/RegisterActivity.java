package com.example.ansal007.conflicto;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ansal007.conflicto.utilis.UIUtils;

/**
 * A login screen that offers login via email/password.
 */
public class RegisterActivity extends AppCompatActivity implements  OnClickListener {

    private static final long TIME_OUT = 1500;
    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView, mConfirmPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mConfirmPasswordView = (EditText) findViewById(R.id.re_password);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_register_button);
        mEmailSignInButton.setOnClickListener(this);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        dialog = UIUtils.getProgressDialogBar(this, ProgressDialog.STYLE_SPINNER, "Registering\nPlease Wait............");
    }


    private void attemptLogin() {


        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);
        mConfirmPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        String confirmPassword = mConfirmPasswordView.getText().toString();


        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.

        if (!TextUtils.isEmpty(confirmPassword) && !isPasswordValid(confirmPassword)){
            mConfirmPasswordView.setError(getString(R.string.error_incorrect_password));
            focusView = mConfirmPasswordView;
            cancel = true;

        }else if ( !TextUtils.isEmpty(confirmPassword) && !TextUtils.isEmpty(password) && !confirmPassword.equals(password)){
            mConfirmPasswordView.setError("Password not matched");
            focusView = mConfirmPasswordView;
            cancel = true;

        }
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            dialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.hide();
                    Toast.makeText(getApplicationContext(), "Cannot validate your login credentials! Retry", Toast.LENGTH_SHORT).show();
                }
            }, TIME_OUT);

        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }


    @Override
    public void onClick(View v) {
        UIUtils.hideKeyBoardFromScreen(this);
        attemptLogin();
    }


}

