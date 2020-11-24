package com.example.gameailatrieuphu.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HighScoreData extends SQLiteOpenHelper {
    Context m_context;
    static String TableHighS = "HighScore";
    public HighScoreData(@Nullable Context context) {
        super(context, TableHighS, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TableHighS+
                "("
                +"id Text primary key,"
                +"HighScore Text )";
        sqLiteDatabase.execSQL(sql);
        ContentValues m_values = new ContentValues();
        m_values.put("id", "1");
        m_values.put("HighScore", "0");
        sqLiteDatabase.insert(TableHighS, null, m_values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public void UpdateHighScore(String HighScore)
    {
        SQLiteDatabase m_SQLite = this.getWritableDatabase();
        ContentValues m_values = new ContentValues();
        m_values.put("HighScore", HighScore);
        m_SQLite.update(TableHighS, m_values, "id=1", null);
    }

    public String GetHighScore()
    {
        SQLiteDatabase m_SQLite = this.getWritableDatabase();
        String sql = "Select HighSore From" + TableHighS+ " where id='1' ";
        Cursor m_cursor = m_SQLite.rawQuery(sql,null);
        m_cursor.moveToFirst();
        return Integer.toString( m_cursor.getColumnIndex("HighScore"));

    }


}
