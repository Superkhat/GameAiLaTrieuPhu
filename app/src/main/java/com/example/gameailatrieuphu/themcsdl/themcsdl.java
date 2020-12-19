package com.example.gameailatrieuphu.themcsdl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gameailatrieuphu.R;
import com.example.gameailatrieuphu.data.DataCauHoi;

public class themcsdl extends AppCompatActivity implements View.OnClickListener {
    EditText edda1,edda2,edda3,edda4,edND;
    Button btnThemcsdl;
    private DataCauHoi mDataBaseCauHoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themcsdl);
        edND=findViewById(R.id.edND);
        edda1=findViewById(R.id.edda1);
        edda2=findViewById(R.id.edda2);
        edda3=findViewById(R.id.edda3);
        edda4=findViewById(R.id.edda4);
        btnThemcsdl=findViewById(R.id.btnThemCsdl);
        btnThemcsdl.setOnClickListener(this);
        mDataBaseCauHoi=new DataCauHoi(this);
    }

    @Override
    public void onClick(View view) {
        mDataBaseCauHoi.them(edND.getText()+"",edda1.getText()+"",edda2.getText()+"",edda3.getText()+"",edda4.getText()+"");
    }
}
