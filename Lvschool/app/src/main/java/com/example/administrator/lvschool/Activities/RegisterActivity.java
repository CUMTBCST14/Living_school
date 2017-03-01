package com.example.administrator.lvschool.Activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.lvschool.R;
import com.example.administrator.lvschool.Users;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/2/7.
 */

public class RegisterActivity extends Activity {
    private EditText ET_name,ET_mobilePhoneNumber,ET_email,ET_address,ET_username;
    private EditText ET_password,ET_password2;
    private Spinner Spinner_sex,Spinner_school,Spinner_academy,Spinner_class;
    private Context context;
    private String[] sex, school,academy,cla;
    private Button Register;
    private Users New_user;
    int sex_pos,school_pos,academy_pos,class_pos;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        //初始化EditText
        ET_username = (EditText)findViewById(R.id.User_name);
        ET_name = (EditText)findViewById(R.id.Name);
        ET_address = (EditText)findViewById(R.id.Address);
        ET_email = (EditText)findViewById(R.id.Email);
        ET_mobilePhoneNumber = (EditText)findViewById(R.id.MobilePhoneNumber);
        ET_password = (EditText)findViewById(R.id.Password);
        ET_password2 = (EditText)findViewById(R.id.Password2);

        //初始化控件
        Spinner_sex=(Spinner) findViewById(R.id.Sex);
        Spinner_school=(Spinner) findViewById(R.id.School);
        Spinner_academy=(Spinner) findViewById(R.id.Academy);
        Spinner_class=(Spinner) findViewById(R.id.Class);

        //建立数据源
        String[] Items_sex = getResources().getStringArray(R.array.user_sex);
        String[] Items_school = getResources().getStringArray(R.array.user_school);
        String[] Items_academy = getResources().getStringArray(R.array.user_academy);
        String[] Items_cla = getResources().getStringArray(R.array.user_class);

        //建立Adapter并绑定数据源
        ArrayAdapter<String> adapter_sex = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,Items_sex);
        ArrayAdapter<String> adapter_school = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,Items_school);
        ArrayAdapter<String> adapter_academy = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,Items_academy);
        ArrayAdapter<String> adapter_class = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,Items_cla);
        adapter_sex.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter_school.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter_academy.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        adapter_class.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        //绑定Adapter到控件
        Spinner_sex.setAdapter(adapter_sex);
        Spinner_school.setAdapter(adapter_school);
        Spinner_academy.setAdapter(adapter_academy);
        Spinner_class.setAdapter(adapter_class);
        Spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = getResources().getStringArray(R.array.user_sex);
                sex_pos = position;
                Toast.makeText(RegisterActivity.this,"你点击的是："+sex[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner_school.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                school = getResources().getStringArray(R.array.user_school);
                school_pos = position;
                Toast.makeText(RegisterActivity.this,"你点击的是："+school[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner_academy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                academy = getResources().getStringArray(R.array.user_academy);
                academy_pos = position;
                Toast.makeText(RegisterActivity.this,"你点击的是："+academy[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cla = getResources().getStringArray(R.array.user_class);
                class_pos = position;
                Toast.makeText(RegisterActivity.this,"你点击的是："+cla[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Register = (Button)findViewById(R.id.register_btn);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean test_result = Test_password();
                if(test_result) {
                    Toast.makeText(RegisterActivity.this, "注册中...", Toast.LENGTH_SHORT).show();
                    RegisterUser();
                }else {
                    //doing nothing
                }
            }
        });
    }


    //注册用户
    private void RegisterUser(){
        New_user = new Users();
        New_user.setSex(sex[sex_pos]);
        New_user.setAcademy(academy[academy_pos]);
        New_user.setMyclass(cla[class_pos]);
        New_user.setSchool(school[school_pos]);
        New_user.setAddress(ET_address.getText().toString());
        New_user.setEmail(ET_email.getText().toString());
        New_user.setMobilePhoneNumber(ET_mobilePhoneNumber.getText().toString());
        New_user.setName(ET_name.getText().toString());
        New_user.setPassword(ET_password.getText().toString());
        New_user.setUser_name(ET_username.getText().toString());
        //save是用不了了吗?
        New_user.signUp(new SaveListener<Users>() {
            @Override
            public void done(Users u,BmobException e){
                if(e==null){
                    Toast.makeText(RegisterActivity.this,"创建数据成功"+u.getObjectId(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(RegisterActivity.this, "注册失败：" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        /*New_user.save(new SaveListener() {
            @Override
            public void done(Object o, BmobException e) {
                if(e==null){
                    Toast.makeText(RegisterActivity.this,"创建数据成功"+u.getObjectId(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(RegisterActivity.this, "注册失败：" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void done(Object o, Object o2) {

            }
        });*/
    }

    //检查密码
    private boolean Test_password(){
        String first = ET_password.getText().toString();
        String second = ET_password2.getText().toString();
        if(first.equals(second)){
            return true;
        }else {
            Toast.makeText(this, "您两次输入密码不一样，请重新输入！", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
