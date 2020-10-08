package com.example.gridsim.Model;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.gridsim.GridAdapter;
import com.example.gridsim.MainActivity;
import com.example.gridsim.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimGridFacade {
    MainActivity main;
    GridView gridView;
    GridAdapter gridAdapter;
    SimulationGrid grid;
    GridCellFactory factory;
    GridCell current = null;
    private static final String TAG = "gridView";
    private int lastClickedID = -1;
    public boolean paused = false;

    public SimGridFacade(MainActivity act, Context c){
        main = act;
        gridView = main.findViewById(R.id.grid);
        gridAdapter = new GridAdapter(c);
        gridView.setAdapter(gridAdapter);
        grid = new SimulationGrid();
        factory = GridCellFactory.getInstance();
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void setUsingJSON(JSONObject res) throws JSONException { // fills the active SimulationGrid with appropriate information from JSON Array coming from the server
        JSONArray array = null;
        try {
            array = (JSONArray) res.get("grid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < 256; i++){
            grid.setCell(i, factory.makeCell((int) array.getJSONArray(i/16).get(i%16), i));
        }
        gridAdapter.copySimulationGrid(grid);
        if(!paused) {
            gridView.invalidateViews();
        }
    }

    public void displayPosition(){
        final TextView pos = (TextView) main.findViewById(R.id.pos);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                pos.setText(grid.getCell(position).getCellType()+ " at "+grid.getCell(position).getCellInfo());
                Log.d(TAG, grid.getCell(position).getCellType()+ " at " +grid.getCell(position).getCellInfo());
                if(grid.getCell(position).getResourceID() != -1){
                    updateCurrentCell(grid.getCell(position));
                }
            }
        });
    }

    public String currentCellInfo(){
        if(current == null){
            return "";
        }
        return current.getCellInfo();
    }

    public void updateCurrentCell(GridCell next){
        current = next;
    }

}
