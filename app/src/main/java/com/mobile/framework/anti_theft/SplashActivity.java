package com.mobile.framework.anti_theft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mobile.framework.anti_theft.Common.Constants;
import com.mobile.framework.anti_theft.Common.SharedPrefUtility;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        CheckAutoLogin();
    }

    private void CheckAutoLogin() {
        SharedPrefUtility prefUtility=new SharedPrefUtility(getApplicationContext());
        int userId= prefUtility.getIntPrefValue(Constants.USER_ID_KEY);
        if(userId==0)
        {
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
        else
        {

        }
    }
}
