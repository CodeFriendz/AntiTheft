package com.mobile.framework.anti_theft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mobile.framework.anti_theft.Common.BaseClass;
import com.mobile.framework.anti_theft.Common.Constants;
import com.mobile.framework.anti_theft.Common.IBaseClassInterface;
import com.mobile.framework.anti_theft.Common.ICleanUp;
import com.mobile.framework.anti_theft.Common.Utils;
import com.mobile.framework.anti_theft.NetUtils.VolleyReq;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener,ICleanUp,IBaseClassInterface{

    Button btLogin;
    EditText edtUser,edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btLogin=(Button)findViewById(R.id.btLogin);
        edtUser=(EditText)findViewById(R.id.etUserName);
        edtPass=(EditText)findViewById(R.id.etPassword);

        btLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btLogin)
        {
            if(InputValid())
            {
                doLogin();
            }
        }
    }

    public void NavigateRegistrationPage(View view)
    {
        Intent intent=new Intent(this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }

    private void doLogin() {
        BaseClass baseClass=new BaseClass();
        String username=edtUser.getText().toString();
        String password=edtPass.getText().toString();

        VolleyReq req=new VolleyReq(this);
        req.LoginRequest(Constants.LOGIN_URL,username,password);
    }


    private boolean InputValid() {
        if(edtUser.getText().toString().equals("") || edtPass.getText().toString().equals(""))
        {
            Utils.ShowTostMessage(this,getResources().getString(R.string.userOrPassEmp));
            return false;
        }
        return true;

    }

    @Override
    public void Cleanup() {

    }

    @Override
    public void ReturnResult(Object result) {
         if(result!=null && (boolean)result)
         {
             Utils.ShowTostMessage(this,"Login Successfull");
             Intent intent=new Intent(this,RegistrationActivity.class);
             startActivity(intent);
         }
    }
}
