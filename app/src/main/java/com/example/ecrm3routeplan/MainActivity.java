package com.example.ecrm3routeplan;

import static com.example.ecrm3routeplan.helper.Constant.apiData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ecrm3routeplan.adapter.AdapterActionCluster;
import com.example.ecrm3routeplan.adapter.BrNameAdapter;
import com.example.ecrm3routeplan.adapter.AdapterParentRouteClusterList;
import com.example.ecrm3routeplan.adapter.AdapterRouteClusterTitleList;
import com.example.ecrm3routeplan.models.RoutePlaneCreationDataModel;
import com.example.ecrm3routeplan.models.RoutePlaneData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvRouteBrName, rvActionButton;
    RoutePlaneCreationDataModel routePlaneCreationDataModel;
    LinearLayout rvTitle, rvRouteClusterParent;
    ImageView ivSelectData;
    CheckBox cbRoute;
    BrNameAdapter brNameAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRouteBrName = findViewById(R.id.rvRouteBrName);
        rvTitle = findViewById(R.id.rvTitle);
        rvRouteClusterParent = findViewById(R.id.rvRouteClusterParent);
        rvActionButton = findViewById(R.id.rvActionButton);
        ivSelectData = findViewById(R.id.ivSelectData);
        cbRoute = findViewById(R.id.cbRoute);

        Gson gson = new Gson();
        routePlaneCreationDataModel = gson.fromJson(apiData, new TypeToken<RoutePlaneCreationDataModel>() {
        }.getType());

        Log.d("CatchActivity", "Route data size: " + routePlaneCreationDataModel.getData().size());
        for (int i = 0; i < routePlaneCreationDataModel.getData().get(0).getClusters().size(); i++) {
            Log.d("CatchActivity", "Cluster " + i + ": " + routePlaneCreationDataModel.getData().get(0).getClusters().get(i).toString());
        }

        brNameAdapter = new BrNameAdapter(this, routePlaneCreationDataModel.getData());
        rvRouteBrName.setLayoutManager(new LinearLayoutManager(this));
        rvRouteBrName.setAdapter(brNameAdapter);

        AdapterRouteClusterTitleList adapterRouteClusterTitleList = new AdapterRouteClusterTitleList(this, routePlaneCreationDataModel.getData());
        for (int i = 0; i < adapterRouteClusterTitleList.getCount(); i++) {
            rvTitle.addView(adapterRouteClusterTitleList.getView(i, null, rvTitle));
        }

        AdapterParentRouteClusterList adapterParentRouteClusterList = new AdapterParentRouteClusterList(this, routePlaneCreationDataModel.getData());
        for (int i = 0; i < adapterParentRouteClusterList.getCount(); i++) {
            rvRouteClusterParent.addView(adapterParentRouteClusterList.getView(i, null, rvRouteClusterParent));
        }

        AdapterActionCluster adapterActionCluster = new AdapterActionCluster(this, routePlaneCreationDataModel.getData());
        rvActionButton.setLayoutManager(new LinearLayoutManager(this));
        rvActionButton.setAdapter(adapterActionCluster);

        ivSelectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDataPopup();
            }
        });

        cbRoute.setOnCheckedChangeListener((buttonView, isChecked) -> {
            brNameAdapter.selectAllAssigned(isChecked);
        });
    }

    void selectDataPopup() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog selectPopup = builder.create();
        LayoutInflater layoutInflater = this.getLayoutInflater();
        final View customView = layoutInflater.inflate(R.layout.select_option_popup, null);
        TextView tvSelectAllData = (TextView) customView.findViewById(R.id.tvSelectAllData);
        TextView tvClearAllData = (TextView) customView.findViewById(R.id.tvClearAllData);

        tvSelectAllData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cbRoute.setChecked(true);
                if (routePlaneCreationDataModel != null) {
                    for (RoutePlaneData data : routePlaneCreationDataModel.getData()) {
                        if (data.getIsAssigned()) {
                            data.setChecked(true);
                        }
                    }
                    brNameAdapter.notifyDataSetChanged();
                }
                selectPopup.dismiss();
            }
        });

        tvClearAllData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cbRoute.setChecked(false);
                if (routePlaneCreationDataModel != null) {
                    for (RoutePlaneData data : routePlaneCreationDataModel.getData()) {
                        if (data.getIsAssigned()) {
                            data.setChecked(false);
                        }
                    }
                    brNameAdapter.notifyDataSetChanged();
                }
                selectPopup.dismiss();
            }
        });
        selectPopup.setCancelable(true);
        selectPopup.setView(customView);
        selectPopup.show();
        selectPopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

}