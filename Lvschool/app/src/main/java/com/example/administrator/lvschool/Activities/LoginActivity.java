package com.example.administrator.lvschool.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.lvschool.MainActivity;
import com.example.administrator.lvschool.R;
import com.example.administrator.lvschool.Users;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/2/12.
 */

public class LoginActivity extends Activity {
    private EditText ET_username,ET_password;
    private Context mContext;
    private Button Login,Register;
    private String Logname,Logpassword,UserID;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.login);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.login_header);
        mContext = this;

        //初始化控件
        ET_username = (EditText)findViewById(R.id.User_username);
        ET_password = (EditText)findViewById(R.id.User_password);
        Login = (Button)findViewById(R.id.login_btn);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logname = ET_username.getText().toString();
                Logpassword = ET_password.getText().toString();
                Toast.makeText(LoginActivity.this,"登陆中...请稍等",Toast.LENGTH_LONG);

                new AsyncTask<Void,Void,Void>(){
                    @Override
                    //疑问：这里为啥要return null呢
                    protected Void doInBackground(Void... params){
                        Users myuser = new Users();
                            myuser.setUser_name(Logname);
                            myuser.setPassword(Logpassword);
                            myuser.login(new SaveListener<Users>() {
                                @Override
                                public void done(Users bmobUser, BmobException e){
                                    if(e == null){
                                        check_login();
                                    }else {
                                        //loge(e);
                                        Toast.makeText(mContext,new String(),Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        return null;
                    }
                }.execute();

            }
        });
        Register = (Button)findViewById(R.id.log_register_btn);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,RegisterActivity.class));
            }
        });



    }
    private void check_login() {
        BmobQuery<Users> query = new BmobQuery<Users>();
        //这两行有点不懂哎
        query.addWhereEqualTo("username", Logname);
        query.addWhereEqualTo("password", Logpassword);
        query.findObjects(new FindListener<Users>() {
            @Override
            public void done(List<Users> list, BmobException e) {
                if (e == null) {
                    for (Users gameScore : list) {
                        UserID = gameScore.getObjectId();
                        startActivity(new Intent(mContext, MainActivity.class));
                    }
                } else {

                }
            }
        });
    }

}
