package com.mobile.framework.anti_theft.Common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by 1 on 08-Oct-17.
 */

public class SharedPrefUtility {

   // private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    public  SharedPrefUtility(Context mContext)
    {
        if(mContext!=null) {
            sharedPreferences = mContext.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
          //  editor=sharedPreferences.edit();
        }
    }

   // private String stringPrefValue;

    public String getStringPrefValue(String key) {
       return sharedPreferences.getString(key,null);
    }

    public void setStringPrefValue(String key,String value) {
       sharedPreferences.edit().putString(key,value).apply();
    }

    public int getIntPrefValue(String key) {
        return sharedPreferences.getInt(key,0);
    }

    public void setIntPrefValue(String key,int value) {
        sharedPreferences.edit().putInt(key,value).apply();
    }

  //  private int intPrefValue;


}
