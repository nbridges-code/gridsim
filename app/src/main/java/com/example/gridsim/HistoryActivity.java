package com.example.gridsim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        String history = getIntent().getExtras().getString("history");
        Log.d("HistoryActivity", history);
        TextView historyView = (TextView) this.findViewById(R.id.historyView);
        historyView.setText(history);
        historyView.setMovementMethod(new ScrollingMovementMethod());
    }
}