package com.example.gameailatrieuphu.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataCauHoi extends SQLiteOpenHelper {
    private  static final String BD_QuanLyCauHoi="quanlycauhoi";
    private static int DB_VERSION=1;
    private static String nameTable="cauhoi";
    private static String nd="noidung";
    private static String da1="dapan1";
    private static String da2="dapan2";
    private static String da3="dapan3";
    private static String da4="dapandung";
    private Context mContext;
    public DataCauHoi(@Nullable Context context) {
        super(context, BD_QuanLyCauHoi, null, DB_VERSION);
        this.mContext=context;
        Toast.makeText(mContext,"chạy o ",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String cautruyvan="create table "+nameTable+
                "("+
                nd +" Text primary key,"+
                da1+" Text ,"+
                da2+" text,"+
                da3+" text,"+
                da4+" text"+
                ")";

        sqLiteDatabase.execSQL(cautruyvan);
        Toast.makeText(mContext, "create successfylly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String value="drop table if exists "+nameTable;
        sqLiteDatabase.execSQL(value);
        onCreate(sqLiteDatabase);
    }
    public long them (String Nd,String d1,String d2,String d3,String d4)
    {
        try
        {
            SQLiteDatabase mSqLiteDatabase=this.getWritableDatabase();
            ContentValues mValues=new ContentValues();
            mValues.put("noidung",Nd);
            mValues.put("dapan1",d1);
            mValues.put("dapan2",d2);
            mValues.put("dapan3",d3);
            mValues.put("dapandung",d4);
            long  rd= mSqLiteDatabase.insert(nameTable,null,mValues);
            mSqLiteDatabase.close();
            Toast.makeText(mContext, "Thêm thành công", Toast.LENGTH_SHORT).show();
            return  rd;
        }
        catch(Exception ex)
        {
            Toast.makeText(mContext, "Thêm That Bai", Toast.LENGTH_SHORT).show();
            return  -1;
        }

    }
    public List<CauHoi> getall()
    {
        try
        {
            List<CauHoi> list=new ArrayList<>();
            String sql="select*from "+nameTable;
            SQLiteDatabase mSqLiteDatabase=this.getReadableDatabase();
            Cursor mCursor=mSqLiteDatabase.rawQuery(sql,null);// cua cau hoi vao mCursor
            mCursor.moveToFirst();// dua Cursor len dau bang cauhoi
            while (!mCursor.isAfterLast())
            {
                CauHoi mCauHoi=new CauHoi();
                mCauHoi.setNoiDung(mCursor.getString(mCursor.getColumnIndex(nd)));
                mCauHoi.setDapAnD(mCursor.getString(mCursor.getColumnIndex(da4)));
                List<String> danS=new ArrayList<>();
                danS.add(mCursor.getString(mCursor.getColumnIndex(da1)));
                danS.add(mCursor.getString(mCursor.getColumnIndex(da2)));
                danS.add(mCursor.getString(mCursor.getColumnIndex(da3)));
                mCauHoi.setmDapAnS(danS);
                list.add(mCauHoi);
                mCursor.moveToNext();
            }
            mSqLiteDatabase.close();
            return list;
        }
        catch(Exception ex)
        {
            Toast.makeText(mContext, "Loi"+ ex.toString(), Toast.LENGTH_SHORT).show();
            return null;
        }

    }

}
