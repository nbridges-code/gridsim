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
import com.example.gridsim.Model.GridCell;
import com.example.gridsim.Model.GridCellFactory;
import com.example.gridsim.Model.SimulationGrid;

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
    SimulationGrid grid = new SimulationGrid();
    GridCellFactory factory = new GridCellFactory();

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

        final GridView gridView = findViewById(R.id.grid);
        final GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);


        final int[] info = new int[256];
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://stman1.cs.unh.edu:6191/games";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray array = (JSONArray) response.get("grid");
                            for(int i = 0; i < 256; i++){
                                grid.setCell(i, factory.makeCell((int) array.getJSONArray(i/16).get(i%16)));
                                //info[i] = (int) array.getJSONArray(i/16).get(i%16);
                                //Log.d("gridView", "my name jeff"+grid.getCell(i).getCellType());
                            }
                            gridAdapter.copySimulationGrid(grid);
                            gridAdapter.refreshStateArray(info);
                            gridView.invalidateViews();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "VolleyError");
            }
        });
        queue.add(request);


        // This happens after a click on an icon. \/
        final TextView pos = (TextView) findViewById(R.id.pos);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int x = (position/16);
                int y = (position%16);
                pos.setText( "Image Position: (row: " + x + ", col: " + y + ") / index:"+ position + " contains " + gridAdapter.getStateArrayValue(position));
                Log.d(TAG, "Location: (row: " + x + ", col: " + y + ") / index:"+position + " has value: " + gridAdapter.getStateArrayValue(position));
            }
        });
    }

}