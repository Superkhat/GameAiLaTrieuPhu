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
   // int a=15;
    int vtCauHoi;
    private Context mContext;
    private List<String> mStringArrayList;
    public TienThuongAdapter(@NonNull Context context, int resource, @NonNull List<String> objects)
    {
        super(context, resource, objects);// resource = id cua xml
        this.mContext=context;
        this.mStringArrayList=objects;
    }
    public void viTriCauHoi(int vtCauHoi)
    {
        this.vtCauHoi=vtCauHoi;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater mLayoutInflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=mLayoutInflater.inflate(R.layout.tienthuong,null);
       TextView txtTienTHuong =convertView.findViewById(R.id.txtTienThuong);
        if((position+1)%5==0)
        {// hien mau o cac moc tien thuong
            txtTienTHuong.setTextColor(Color.parseColor("#FFFFFFFF"));
        }
        else
            txtTienTHuong.setTextColor(Color.parseColor("#FFFFC107"));
        int vt=15-position;
        String HienThi= vt+"    "+"$"+mStringArrayList.get(position);
        txtTienTHuong.setText(HienThi);
        if(vt==vtCauHoi)// vi tri cau hoi hine tai
            txtTienTHuong.setBackgroundColor(Color.parseColor("#FF2196F3"));
        return convertView;
    }
}

