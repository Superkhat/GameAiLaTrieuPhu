package com.example.gameailatrieuphu.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gameailatrieuphu.R;

import java.util.ArrayList;
import java.util.List;

public class TienThuongAdapter extends ArrayAdapter<String> {
    private Context mContext;
    private List<String> mStringArrayList;
    public TienThuongAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mStringArrayList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=mLayoutInflater.inflate(R.layout.tienthuong,null);
       TextView txtTienTHuong =convertView.findViewById(R.id.txtTienThuong);
        if((position+1)%5==0)
        {
            txtTienTHuong.setTextColor(Color.parseColor("#FFFFFFF"));
        }
        else
            txtTienTHuong.setTextColor(Color.parseColor("#FFFFC107"));
        int vt=position+1;
        String HienThi= vt+"    "+"$"+mStringArrayList.get(position);
        txtTienTHuong.setText(HienThi);
        return convertView;
    }
}

