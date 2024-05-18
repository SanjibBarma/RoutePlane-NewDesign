package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.helper.NonScrollableRecyclerView;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class AdapterParentRouteCluster extends RecyclerView.Adapter<AdapterParentRouteCluster.ViewHolder> {
    Context context;
    List<RoutePlaneData> routePlaneData;

    public AdapterParentRouteCluster(Context context, List<RoutePlaneData> routePlaneData) {
        this.context = context;
        this.routePlaneData = routePlaneData;
    }

    @NonNull
    @Override
    public AdapterParentRouteCluster.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= (View) LayoutInflater.from(context).inflate(R.layout.list_route_cluster_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterParentRouteCluster.ViewHolder holder, int position) {

        AdapterChildRouteCluster adapterChildRouteCluster = new AdapterChildRouteCluster(context, routePlaneData.get(position).getClusters());
//        holder.rvClusterDatas.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rvClusterDatas.setLayoutManager(new GridLayoutManager(context, 1, RecyclerView.HORIZONTAL, false));
        holder.rvClusterDatas.setAdapter(adapterChildRouteCluster);


    }

    @Override
    public int getItemCount() {
        return routePlaneData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvClusterDatas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rvClusterDatas = itemView.findViewById(R.id.rvClusterDatas);
        }
    }
}
