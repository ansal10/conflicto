package com.example.ansal007.conflicto.utilis;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;

/**
 * Created by Ansal007 on 7/8/16.
 */
public class UIUtils {

    public static void hideKeyBoardFromScreen(Activity context){
        if(context.getCurrentFocus()!=null){
            InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static ProgressDialog getProgressDialogBar(Activity context, int style, String message){
        ProgressDialog dialog = new ProgressDialog(context); // this = YourActivity
        dialog.setProgressStyle(style);
        dialog.setMessage(message);
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        return dialog ;
    }
}
