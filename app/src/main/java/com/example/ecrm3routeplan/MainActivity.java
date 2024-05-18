package com.example.ecrm3routeplan;

import static com.example.ecrm3routeplan.Constant.apiData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.HorizontalScrollView;

import com.example.ecrm3routeplan.adapter.AdapterActionCluster;
import com.example.ecrm3routeplan.adapter.AdapterParentRouteCluster;
import com.example.ecrm3routeplan.adapter.AdapterRouteClusterTitle;
import com.example.ecrm3routeplan.adapter.BrNameAdapter;
import com.example.ecrm3routeplan.helper.NonScrollableRecyclerView;
import com.example.ecrm3routeplan.models.RoutePlaneCreationDataModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvRouteBrName, rvTitle, rvRouteClusterParent, rvActionButton;
    RoutePlaneCreationDataModel routePlaneCreationDataModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRouteBrName = findViewById(R.id.rvRouteBrName);
        rvTitle = findViewById(R.id.rvTitle);
        rvRouteClusterParent = findViewById(R.id.rvRouteClusterParent);
        rvActionButton = findViewById(R.id.rvActionButton);

        Gson gson = new Gson();
        routePlaneCreationDataModel = gson.fromJson(apiData, new TypeToken<RoutePlaneCreationDataModel>() {
        }.getType());

        Log.d("CatchActivity", "Route data size: " + routePlaneCreationDataModel.getData().size());
        for (int i = 0; i < routePlaneCreationDataModel.getData().get(0).getClusters().size(); i++) {
            Log.d("CatchActivity", "Cluster " + i + ": " + routePlaneCreationDataModel.getData().get(0).getClusters().get(i).toString());
        }

        BrNameAdapter brNameAdapter = new BrNameAdapter(this, routePlaneCreationDataModel.getData());
        rvRouteBrName.setLayoutManager(new LinearLayoutManager(this));
        rvRouteBrName.setAdapter(brNameAdapter);

        AdapterRouteClusterTitle adapterRouteClusterTitle = new AdapterRouteClusterTitle(this, routePlaneCreationDataModel.getData());
        rvTitle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rvTitle.setLayoutManager(new GridLayoutManager(this, 1, RecyclerView.HORIZONTAL, false));
        rvTitle.setAdapter(adapterRouteClusterTitle);

        AdapterParentRouteCluster adapterParentRouteCluster = new AdapterParentRouteCluster(this, routePlaneCreationDataModel.getData());
//        rvRouteClusterParent.setLayoutManager(new LinearLayoutManager(this));
        rvRouteClusterParent.setLayoutManager(new GridLayoutManager(this, 1, RecyclerView.VERTICAL, false));
        rvRouteClusterParent.setAdapter(adapterParentRouteCluster);

        AdapterActionCluster adapterActionCluster = new AdapterActionCluster(this, routePlaneCreationDataModel.getData());
        rvActionButton.setLayoutManager(new LinearLayoutManager(this));
        rvActionButton.setAdapter(adapterActionCluster);
    }
}