package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.MainActivity;
import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.adapter.AdapterChildRouteCluster;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class AdapterParentRouteClusterList extends BaseAdapter {
    Context context;
    List<RoutePlaneData> routePlaneData;
    private LayoutInflater inflater;
    public AdapterParentRouteClusterList(Context context, List<RoutePlaneData> routePlaneData) {
        this.context = context;
        this.routePlaneData = routePlaneData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return routePlaneData.size();
    }

    @Override
    public Object getItem(int i) {
        return routePlaneData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_route_cluster_layout, parent, false);
        }

        RecyclerView rvClusterDatas = convertView.findViewById(R.id.rvClusterDatas);

        AdapterChildRouteCluster adapterChildRouteCluster = new AdapterChildRouteCluster(context, routePlaneData.get(position).getClusters());
//        holder.rvClusterDatas.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rvClusterDatas.setLayoutManager(new GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false));
        rvClusterDatas.setAdapter(adapterChildRouteCluster);
        return convertView;
    }
}
