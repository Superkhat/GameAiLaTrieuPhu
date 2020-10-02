package com.example.gameailatrieuphu;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gameailatrieuphu.adapter.TienThuongAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView mListViewtt;
    private List<String> mStringList;
    private String [] ss={"100","200","300","400","500",
    "1000","2000","4000","8000","16000","32000","64000",
            "125000","2500000","50000000","100000000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        mStringList=new ArrayList<>();
        mListViewtt=findViewById(R.id.lsvTienThuong);
        themDataLsv();
        TienThuongAdapter mAdapter=new TienThuongAdapter (this,0,mStringList);
       // mListViewtt.setAdapter(mAdapter);
    }
    public void themDataLsv()
    {
        for(int i=0;i<ss.length;++i)
        mStringList.add(ss[i]);


    }
}
