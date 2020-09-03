// Toast button code by Sabith Pkc Mnr on YouTube
package com.example.gridsim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Number 1's text", Toast.LENGTH_SHORT).show();
            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Number 2's text", Toast.LENGTH_LONG).show();
            }
        });

    }
}