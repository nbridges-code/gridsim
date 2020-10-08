// Toast button code by Sabith Pkc Mnr on YouTube
package com.example.gridsim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gridsim.Model.SimGridFacade;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    private static final String TAG = "gridView";
    private static Poller poller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SimGridFacade facade = new SimGridFacade(MainActivity.this, this);
        poller = Poller.getInstance(this);

        facade.displayPosition();

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                // pause
            }
        });
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                showHistory(facade.currentCellInfo());
                // Log.d(TAG, facade.currentCellInfo());
            }
        });
    }

    public void showHistory(String history){
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putExtra("history", history);
        startActivity(intent);
    }

}