package com.example.gameailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBatDau;
    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBatDau=findViewById(R.id.btnBatDau);
        btnBatDau.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mIntent=new Intent(this,MainActivity2.class);
        startActivity(mIntent);
    }
}
