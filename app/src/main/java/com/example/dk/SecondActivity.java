package com.example.dk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {
    EditText et_Name, user_email, user_pass,user_mob;
    ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et_Name=findViewById(R.id.et_Name);
        user_email=findViewById(R.id.user_email);
        user_pass=findViewById(R.id.user_pass);
        user_mob=findViewById(R.id.user_mob);
        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(view ->{
            String name= et_Name.getText().toString().trim();
            String email=user_email.getText().toString().trim();
            String password = user_pass.getText().toString().trim();
            String mobile=user_mob.getText().toString().trim();
            Intent i= new Intent(this,MainActivity.class);
            i.putExtra("name",name);
            i.putExtra("email",email);
            i.putExtra("password",password);
            i.putExtra("mobile",mobile);
            startActivity(i);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String name= et_Name.getText().toString().trim();
        String email=user_email.getText().toString().trim();
        String password = user_pass.getText().toString().trim();
        String mobile=user_mob.getText().toString().trim();
        Intent i= new Intent(this,MainActivity.class);
        i.putExtra("name",name);
        i.putExtra("email",email);
        i.putExtra("password",password);
        i.putExtra("mobile",mobile);
        startActivity(i);

    }
}