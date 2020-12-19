package com.example.gameailatrieuphu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TroGiupKhanGia_dialog extends Dialog {
    TextView txta, txtb, txtc, txtd;
    List<TextView> mTextViews;

    public TroGiupKhanGia_dialog(@NonNull Context context, int vtcd) {
        super(context);
        setContentView(R.layout.trogiupkhangia);
        mTextViews = new ArrayList<>();
        txta = findViewById(R.id.txtA);
        mTextViews.add(txta);
        txtb = findViewById(R.id.txtB);
        mTextViews.add(txtb);
        txtc = findViewById(R.id.txtC);
        mTextViews.add(txtc);
        txtd = findViewById(R.id.txtD);
        mTextViews.add(txtd);
        //    mTextViews.get(1).setText("hgfd");
        Random r = new Random();
        int dapans[] = new int[4];
        int tong = 100;
        for (int i = 0; i < 3; ++i) {
            dapans[i] = r.nextInt(25);
            tong -= dapans[i];
        }
        int dad = tong;
        int k = 1;
        for (int i = 0; i < mTextViews.size(); ++i) {
            if (i == vtcd) {
                System.out.println("vi tri cau dung " + vtcd);
                    mTextViews.get(i).setText(dad+"%");
            }
           else {
                mTextViews.get(i).setText( dapans[k - 1] + "%");
                k++;
            }
        }

    }
}



