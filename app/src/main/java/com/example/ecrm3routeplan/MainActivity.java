package com.example.ecrm3routeplan;

import static com.example.ecrm3routeplan.Constant.apiData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ecrm3routeplan.adapters.AdapterBrName;
import com.example.ecrm3routeplan.adapters.AdapterRouteCluster;
import com.example.ecrm3routeplan.models.RoutePlaneCreationDataModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvRouteBrName, rvClusterDatas;
    RoutePlaneCreationDataModel routePlaneCreationDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRouteBrName = findViewById(R.id.rvRouteBrName);
        rvClusterDatas = findViewById(R.id.rvClusterDatas);

        Gson gson = new Gson();
        routePlaneCreationDataModel = gson.fromJson(apiData, new TypeToken<RoutePlaneCreationDataModel>() {
        }.getType());

        AdapterBrName adapterBrName = new AdapterBrName(this, routePlaneCreationDataModel.getData());
        rvRouteBrName.setLayoutManager(new LinearLayoutManager(this));
        rvRouteBrName.setAdapter(adapterBrName);



        AdapterRouteCluster adapterRouteCluster = new AdapterRouteCluster(this, routePlaneCreationDataModel.getData());
        rvClusterDatas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvClusterDatas.setAdapter(adapterRouteCluster);


    }
}