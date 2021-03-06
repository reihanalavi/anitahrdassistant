package com.akhza.anitahrdassistant.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.akhza.anitahrdassistant.R;
import com.akhza.anitahrdassistant.VidcallActivity;
import com.akhza.anitahrdassistant.getsetExpression;

import org.opencv.android.OpenCVLoader;

public class EntranceActivity extends AppCompatActivity {

    SharedPreferences loginfo;

    static {
        if(OpenCVLoader.initDebug()) {
            Log.d("Message: ", "Ok");
        } else {
            Log.d("Message: ", "Nope");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        loginfo = this.getSharedPreferences("Login Info", Context.MODE_PRIVATE);
        Boolean logininfo = loginfo.getBoolean("log", false);
        String email = loginfo.getString("email", "");
        String state = loginfo.getString("state", "");


        if (logininfo == true) {
            Log.d("EMAIL SHAREDPREF", email);
            if(state.equals("2")) {
                startActivity(new Intent(getApplicationContext(), HRDDashboardActivity.class));
            } else if(state.equals("3")) {
                startActivity(new Intent(getApplicationContext(), ApplicantsDashboardActivity.class));
            }
        } else {
            Toast.makeText(EntranceActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
        }

        Button mulai_btn = findViewById(R.id.mulai_btn);

        mulai_btn.setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), GetStartedActivity.class)));



    }
}