package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.Cluster;

import java.util.List;

public class AdapterChildRouteCluster extends RecyclerView.Adapter<AdapterChildRouteCluster.ViewHolder> {
    Context context;
    List<Cluster> clusters;
    public AdapterChildRouteCluster(Context context, List<Cluster> clusters) {
        this.context = context;
        this.clusters = clusters;
    }

    @NonNull
    @Override
    public AdapterChildRouteCluster.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= (View) LayoutInflater.from(context).inflate(R.layout.cluster_child_layoud,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterChildRouteCluster.ViewHolder holder, int position) {

        holder.tvRoute.setText(clusters.get(position).getRouteName());
        holder.tvCluster.setText(clusters.get(position).getClusterName());

        Log.d("positionClusterSize: ", clusters.size()+"");


    }

    @Override
    public int getItemCount() {
        return clusters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvRoute, tvCluster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRoute = itemView.findViewById(R.id.tvRoute);
            tvCluster = itemView.findViewById(R.id.tvCluster);
        }
    }
}
