package com.example.recycleview_viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tvNameUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNameUser = findViewById(R.id.tvNameUser);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null){
            return;
        }else{
            User user = (User) bundle.get("Object User");
            tvNameUser.setText(user.getName());
        }

    }
}