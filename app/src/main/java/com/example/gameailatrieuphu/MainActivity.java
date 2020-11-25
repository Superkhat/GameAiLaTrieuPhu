package com.example.gameailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gameailatrieuphu.data.CauHoi;
import com.example.gameailatrieuphu.data.DataCauHoi;
import com.example.gameailatrieuphu.themcsdl.themcsdl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnBatDau,btnHuongDan, btnHighScore;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBatDau=findViewById(R.id.btnBatDau);
        btnBatDau.setOnClickListener(this);

        btnHighScore= findViewById(R.id.btnHighScore);
        btnHighScore.setOnClickListener(this);

        btnHuongDan=findViewById(R.id.btnHuongDan);
        btnHuongDan.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnBatDau:
                mIntent=new Intent(this,MainActivity2.class);
                startActivity(mIntent);

                break;
            case R.id.btnHuongDan:
                mIntent=new Intent(this, themcsdl.class);
                startActivity(mIntent);

                break;
            case R.id.btnHighScore:

                HighScore m_HS = new HighScore(this);

                m_HS.show();
                //m_HS.SetHS();
                break;
        }


    }
}
