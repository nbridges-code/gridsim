// Toast button code by Sabith Pkc Mnr on YouTube
package com.example.gridsim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JSONObject square = new JSONObject();
        try {
            square.put("img", R.drawable.square);
            square.put("value", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject dot = new JSONObject();
        try {
            dot.put("img", R.drawable.dot);
            dot.put("value", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Number 1's text", Toast.LENGTH_SHORT).show();
            }
        });

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Number 2's text", Toast.LENGTH_SHORT).show();
            }
        });

        GridView gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new GridAdapter(this));
        // This happens after a click on an icon. \/
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(MainActivity.this, "Image Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });
//        GridAdapter adapter = new GridAdapter();
//        gridView.setAdapter(adapter);
    }
}