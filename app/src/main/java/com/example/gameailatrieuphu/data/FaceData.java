package com.example.gameailatrieuphu.data;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gameailatrieuphu.MainActivity;
import com.example.gameailatrieuphu.MainActivity2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FaceData {
    private DataCauHoi mDataCauHoi;
    public CauHoi taoCauHoi(int capDo, Context mContext)
    {
        CauHoi mCauHoi=new CauHoi();
        try
    {

        mDataCauHoi=new DataCauHoi(mContext);
        List<CauHoi> ListDataCauHoi=new ArrayList<>(mDataCauHoi.getall());
        Random random=new Random();
        int cau=random.nextInt(28);
        Toast.makeText(mContext,ListDataCauHoi.size()+"",Toast.LENGTH_LONG).show();
        mCauHoi.setNoiDung(ListDataCauHoi.get(cau).getNoiDung());
        mCauHoi.setDapAnD(ListDataCauHoi.get(cau).getDapAnD());
        mCauHoi.setmDapAnS(ListDataCauHoi.get(cau).getmDapAnS());
       /*Random random=new Random();
        int so1= random.nextInt(100);
        int so2= random.nextInt(100);
       int tong=so1+so2;
       String noiDungCauHoi=so1+" + "+so2+" = ? "+"("+capDo+")";

       mCauHoi.setNoiDung(noiDungCauHoi);
       mCauHoi.setDapAnD(""+tong);
        List<String> mListDapAnSai=new ArrayList<>();
        do {
           int tongFace=random.nextInt(200);
            if(tongFace!=tong)
            {
                mListDapAnSai.add(""+tongFace);
            }


        } while (mListDapAnSai.size()!=3);
        mCauHoi.setmDapAnS(mListDapAnSai);*/
        return mCauHoi;
    }
    catch (Exception ex)
    {
        Toast.makeText(mContext, "Loi"+ex.toString(), Toast.LENGTH_SHORT ).show();
    }

        return mCauHoi;

    }
}
