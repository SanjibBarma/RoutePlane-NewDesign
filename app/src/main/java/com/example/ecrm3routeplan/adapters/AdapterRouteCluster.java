package com.example.ecrm3routeplan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class AdapterRouteCluster extends RecyclerView.Adapter<AdapterRouteCluster.ViewHolder> {
    Context context;
    List<RoutePlaneData> data;
    public AdapterRouteCluster(Context context, List<RoutePlaneData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterRouteCluster.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cluster_child_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRouteCluster.ViewHolder holder, int position) {
        holder.tvRouteName.setText(data.get(position).getClusters().get(position).getRouteName());
        holder.tvClusterName.setText(data.get(position).getClusters().get(position).getClusterName());

        if (position == 0){
            holder.linearLayout2.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout2;
        TextView tvRouteName, tvClusterName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout2 = itemView.findViewById(R.id.linearLayout2);
            tvRouteName = itemView.findViewById(R.id.tvRouteName);
            tvClusterName = itemView.findViewById(R.id.tvClusterName);
        }
    }
}
