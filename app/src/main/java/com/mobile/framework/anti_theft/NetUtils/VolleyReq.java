package com.mobile.framework.anti_theft.NetUtils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mobile.framework.anti_theft.Common.BaseClass;
import com.mobile.framework.anti_theft.Common.IBaseClassInterface;
import com.mobile.framework.anti_theft.Common.ICleanUp;
import com.mobile.framework.anti_theft.Common.Utils;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class VolleyReq implements ICleanUp {
    private Context mContext;
    private IBaseClassInterface _baseObject;
    RequestQueue queue;
    public VolleyReq(Context mContext)
    {
        this.mContext=mContext;
        _baseObject=(IBaseClassInterface)mContext;
        queue = Volley.newRequestQueue(mContext);
        //Reques
        //Req
    }
    public void LoginRequest(String url, final String username, final String password)
    {

        try {
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("user", username);
        jsonBody.put("pass", password);
        final String requestBody = jsonBody.toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(response.equals("success"))
                {
                    if(_baseObject!=null)
                    {
                        _baseObject.ReturnResult(true);
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("user",username);
                params.put("pass",password);

                return params;
            }

        };

        requestQueue.add(stringRequest);
    } catch (JSONException e) {
        e.printStackTrace();
    }



    }

    @Override
    public void Cleanup() {
       if (_baseObject!=null)
       {
           _baseObject=null;
       }
    }
}
