package com.example.gameailatrieuphu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gameailatrieuphu.adapter.TienThuongAdapter;
import com.example.gameailatrieuphu.data.CauHoi;
import com.example.gameailatrieuphu.data.DataCauHoi;
import com.example.gameailatrieuphu.data.FaceData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity  {
    private ListView mListViewtt;
    private TextView txtCauHoiHT;
    private  TienThuongAdapter mAdapter;
    private List<String> mStringList;// danh sach tien thuong
    private TextView txtCauHoi,txtThuaGame;
    private Button btnCauTraLoi1,btnCauTraLoi2,btnCauTraLoi3,btnCauTraLoi4;
    private CauHoi mCauHoi;
    private int vtCauHoi=1;
    private List<Button> ListbtnCauTraLoi;
    private boolean OneClick= false;
    String cauTraLoi;
    FaceData faceData;
    View.OnClickListener listener;
    private String [] ss={
            "200",
            "300",
            "400",
            "500",
            "1000",
            "2000",
            "4000",
            "8000",
            "16000",
            "32000",
            "64000",
            "125000",
            "2500000",
            "50000000",
            "100000000"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);
        txtCauHoiHT=findViewById(R.id.cauHoiHT);
        //Toast.makeText(this, "Chay Create", Toast.LENGTH_SHORT).show();
        khoiTao();
        mListViewtt.setAdapter(mAdapter);
        setCauHoi();
        OnClick();
    }
    public void khoiTao()
    {
        try
        {
            mCauHoi=new CauHoi();
            ListbtnCauTraLoi=new ArrayList<>();
            mStringList=new ArrayList<>();// danh sach tien thuong
            mListViewtt=findViewById(R.id.lsvTienThuong);

            themDataLsv();//Them du lieu ss vao list String
            mAdapter=new TienThuongAdapter (this,R.layout.layout2,mStringList);
            txtCauHoi=findViewById(R.id.txtCauHoi);
            btnCauTraLoi1=findViewById(R.id.btnCauTraLoi1);
            btnCauTraLoi2=findViewById(R.id.btnCauTraLoi2);
            btnCauTraLoi3=findViewById(R.id.btnCauTraLoi3);
            btnCauTraLoi4=findViewById(R.id.btnCauTraLoi4);
            ListbtnCauTraLoi.add(btnCauTraLoi1);
            ListbtnCauTraLoi.add(btnCauTraLoi2);
            ListbtnCauTraLoi.add(btnCauTraLoi3);
            ListbtnCauTraLoi.add(btnCauTraLoi4);
            txtThuaGame=findViewById(R.id.txtThuaGame);
            txtThuaGame.setVisibility(View.GONE);
            faceData=new FaceData();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Loi"+ex.toString(),Toast.LENGTH_SHORT).show();
        }


    }

    public void OnClick() {
     listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OneClick)
                {
                    kiemTraCauTraLoi((Button)view);
                }

            }
        };
       /* btnCauTraLoi1.setOnClickListener(listener);
        btnCauTraLoi2.setOnClickListener(listener);
        btnCauTraLoi3.setOnClickListener(listener);
        btnCauTraLoi4.setOnClickListener(listener);*/
        for(Button i:ListbtnCauTraLoi)
        {
            if(!OneClick)
            {
            i.setOnClickListener(listener);
            OneClick = true;            }
        }

    }

    public  void  kiemTraCauTraLoi(Button btncauTraLoi)
    {
        cauTraLoi= (String) btncauTraLoi.getText();
        btncauTraLoi.setBackgroundResource(R.drawable.mauchonbutton);
        new CountDownTimer(2000,100)
        {
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
            for(Button btn :ListbtnCauTraLoi) {
                String ctl = btn.getText().toString();
                if (ctl.equals(mCauHoi.getDapAnD())) {
                    btn.setBackgroundResource(R.drawable.caudung);
                    break;
                }

            }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long l) {
                    }
                    @Override
                    public void onFinish() {
                        if(cauTraLoi.equals(mCauHoi.getDapAnD()))
                        {
                            vtCauHoi++;
                            if(vtCauHoi>15)
                            {
                                vtCauHoi=15;
                                txtThuaGame.setVisibility(View.VISIBLE);
                                txtThuaGame.setText("Chúc mừng bạn đã trở thành triệu phú với số tiền "+ss[vtCauHoi-1]+"$");
                                return;
                            }
                            setCauHoi();
                        }
                        else
                        {
                            txtThuaGame.setVisibility(View.VISIBLE);
                            txtThuaGame.setText("Bạn ra về với số tiền thưởng là "+ss[vtCauHoi-1]+"$");

                        }

                    }
                }.start();
            }
        }.start();

          }

    public void themDataLsv()
    {
        try {
            for(int i=ss.length-1;i>=0;--i)
                mStringList.add(ss[i]);
        }
        catch(Exception ex)
        {
            Toast.makeText(this, "Loi"+ex.toString(), Toast.LENGTH_SHORT).toString();
        }

    }

    public void setCauHoi()
    {
        txtCauHoiHT.setText("Bạn đang ở câu số "+vtCauHoi);
        mCauHoi=faceData.taoCauHoi(vtCauHoi,this);
        List<String> mCauTraLoi=new ArrayList<>(mCauHoi.getmDapAnS());
        mCauTraLoi.add(mCauHoi.getDapAnD());
        txtCauHoi.setText(mCauHoi.getNoiDung()+" ");
        Random mRandom=new Random();
        for(int i=0;i<=4;++i)
        {
            int v1=mRandom.nextInt(4);
            int v2=mRandom.nextInt(4);
            String temp=mCauTraLoi.get(v1);
            mCauTraLoi.set(v1,mCauTraLoi.get(v2));
            mCauTraLoi.set(v2,temp);
        }
       /* btnCauTraLoi1.setText(mCauTraLoi.get(0));
        btnCauTraLoi2.setText(mCauTraLoi.get(1));
        btnCauTraLoi3.setText(mCauTraLoi.get(2));
        btnCauTraLoi4.setText(mCauTraLoi.get(3));*/
       for(int i=0;i<ListbtnCauTraLoi.size();++i)
       {
           ListbtnCauTraLoi.get(i).setOnClickListener(listener);
           ListbtnCauTraLoi.get(i).setVisibility(View.VISIBLE);
           ListbtnCauTraLoi.get(i).setBackgroundResource(R.drawable.custormbutton);
           ListbtnCauTraLoi.get(i).setText(mCauTraLoi.get(i));
       }
       mAdapter.viTriCauHoi(vtCauHoi);
    }

    boolean troGiup5050=true;
    public void troGiup5050(View view) {
        if(troGiup5050==false)
        {
            return;
        }
        else
        {
            Random r=new Random();
            int sdaa=2;
            while(sdaa>0){
                int vtsdaa=r.nextInt(4);
                TextView txt=ListbtnCauTraLoi.get(vtsdaa);
                if(txt.getVisibility()==View.VISIBLE&&txt.getText().toString().equals(mCauHoi.getDapAnD())==false)
                {
                 txt.setVisibility(View.INVISIBLE);
                 txt.setOnClickListener(null);
                 sdaa--;
                 Toast.makeText(this,"so"+sdaa,Toast.LENGTH_LONG).show();
                }
            }
            troGiup5050=false;
        }
    }
    boolean troGiupKhanGia=true;

    public void troGiupKhanGia(View view)
    {
        if(troGiupKhanGia==false)
            return;
       for(int i=0;i<ListbtnCauTraLoi.size();++i)
       {
           TextView txt=ListbtnCauTraLoi.get(i);
           if(txt.getText().toString().equals(mCauHoi.getDapAnD()))
           {
               TroGiupKhanGia_dialog dialog = new TroGiupKhanGia_dialog(this,i);
               dialog.show();
           break;
           }
       }
       troGiupKhanGia=false;

    }
    boolean doiCauHoi=true;
    public void DoiCauHoi(View view)
    {
        if(doiCauHoi==false)
        {
            return;
        }
        setCauHoi();
        OneClick=false;
        doiCauHoi=false;
    }
}
