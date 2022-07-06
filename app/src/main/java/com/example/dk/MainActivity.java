package com.example.dk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText et_Name, user_email, user_pass,pass,user_mob;
    Button login_btn;
    RadioButton f_cat,m_cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_btn=findViewById(R.id.login_btn);
        et_Name=findViewById(R.id.et_Name);
        user_email=findViewById(R.id.user_email);
        user_pass=findViewById(R.id.user_pass);
        pass=findViewById(R.id.pass);
        user_mob=findViewById(R.id.user_mob);
        f_cat=findViewById(R.id.m_cat);
        m_cat=findViewById(R.id.f_cat);

        login_btn.setOnClickListener(view -> {
            boolean check = (validUser() & validEmail() & validPassword() & validConfirm() & validMobile() & validRadio());

            if(check == true){
                String name= et_Name.getText().toString().trim();
                String email=user_email.getText().toString().trim();
                String password = user_pass.getText().toString().trim();
                String mobile=user_mob.getText().toString().trim();
                Intent i= new Intent(this,SecondActivity.class);
                i.putExtra("name",name);
                i.putExtra("email",email);
                i.putExtra("password",password);
                i.putExtra("mobile",mobile);
                startActivity(i);
            }
        });

        Intent i=getIntent();
        String name=i.getStringExtra("name");
        String email=i.getStringExtra("email");
        String password=i.getStringExtra("password");
        String mobile=i.getStringExtra("mobile");
        et_Name.setText(name);
        user_email.setText(email);
        user_pass.setText(password);
        user_mob.setText(mobile);
    }

    private boolean validRadio() {
        if(!f_cat.isChecked() && !m_cat.isChecked()){
            f_cat.setError("Select Gender");
            return false;
        } else
            f_cat.setError(null);
        return true;
    }

    private boolean validMobile() {
        String mobile = user_mob.getText().toString().trim();
        String mobilePattern = "[0-9]{10}";
        if(mobile.isEmpty()){
            user_mob.setError("Enter Number");
            return false;
        } else if(!mobile.matches(mobilePattern)){
            user_mob.setError("Invalid Number");
            return false;
        } else
            user_mob.setError(null);
        return true;
    }

    private boolean validConfirm() {
        String cpassword = pass.getText().toString().trim();
        String password = user_pass.getText().toString().trim();
        String passwordVal = "^" +  "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if(cpassword.isEmpty()){
            pass.setError("Enter Password");
            return false;
        } else if(!cpassword.equals(password)) {
            pass.setError("Password does not match");
            return false;
        } else
            pass.setError(null);
        return true;
    }

    private boolean validPassword() {
        String password = user_pass.getText().toString().trim();
        String passwordVal = "^" +  "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if(password.isEmpty()){
            user_pass.setError("Enter Password");
            return false;
        } else if(!password.matches(passwordVal)){
            user_pass.setError("Invalid Email");
            return false;
        } else
            user_pass.setError(null);
        return true;
    }

    private boolean validEmail() {
        String email = user_email.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(email.isEmpty()){
            user_email.setError("Enter Email");
            return false;
        } else if(!email.matches(emailPattern)){
            user_email.setError("Invalid Email");
            return false;
        } else
            user_email.setError(null);
        return true;
    }

    private boolean validUser() {
        String name = et_Name.getText().toString().trim();
        if(name.isEmpty()){
            et_Name.setError("Enter Name");
            return false;
        } else
            et_Name.setError(null);
        return true;
    }

}
