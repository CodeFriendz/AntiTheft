package com.mobile.framework.anti_theft.Common;

import android.content.Context;
import android.widget.Toast;

public class Utils {
    public static void ShowTostMessage(Context mContext,String message)
    {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
