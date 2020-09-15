// Toast button code by Sabith Pkc Mnr on YouTube
package com.example.gridsim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.*;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    GridView gridView;
    private static final String TAG = "gridView";

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
                Toast.makeText(getApplicationContext(), "Number 2's text", Toast.LENGTH_SHORT).show();
            }
        });


        final GridView gridView = (GridView) findViewById(R.id.grid);
        final GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);

        final JSONObject serverResponse;
        final TextView textView = (TextView) findViewById(R.id.text);
        final int[] info = new int[256];
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://stman1.cs.unh.edu:6191/games";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d(TAG, "Server response: " + response.toString());
                        try {
                            JSONArray array = (JSONArray) response.get("grid");
                            for(int i = 0; i < 256; i++){
                                info[i] = (int) array.getJSONArray(i/16).get(i%16);
                                //Log.d(TAG, i + ": " + info[i]);
                                gridAdapter.setStateArrayValue(i, info[i]);
                            }
                            gridView.invalidateViews();
/*
                            for(int i = 0; i < 16; i++) {
                                Log.d(TAG, i + ": " + array.getJSONArray(i).toString());
                                for(int j = 0; j < 16; j++){
                                    info[track[0]] = (int) array.getJSONArray(i).get(j);
                                    track[0]++;
                                }
                            }
*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });
        queue.add(request);


        // This happens after a click on an icon. \/
        final TextView pos = (TextView) findViewById(R.id.pos);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int x = (position/16)+1;
                int y = (position%16)+1;
                pos.setText( "Image Position: (row: " + x + ", col: " + y + ") / index:"+ position + " contains " + gridAdapter.getStateArrayValue(position));
                //Toast.makeText(MainActivity.this, "Image Position: " + position + " contains " + gridAdapter.getStateArrayValue(position), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Location: (row: " + x + ", col: " + y + ") / index:"+position + " has value: " + gridAdapter.getStateArrayValue(position));
            }
        });
    }
}