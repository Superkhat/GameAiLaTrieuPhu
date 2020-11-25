package com.example.gameailatrieuphu;

import android.app.Dialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.gameailatrieuphu.data.HighScoreData;

public class HighScore extends Dialog {

    Context m_context;
    TextView m_HighScore;
    public HighScore(@NonNull Context context) {
        super(context);
        m_context = context;
        setContentView(R.layout.activity_diem_cao);
        m_HighScore = findViewById(R.id.m_HighScore);
        HighScoreData m_HighData = new HighScoreData(m_context);
        m_HighScore.setText(m_HighData.GetHighScore());

    }

    public void SetHS()
    {
        HighScoreData m_HighData = new HighScoreData(m_context);

    }
}
