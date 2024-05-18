package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class AdapterRouteClusterTitle extends RecyclerView.Adapter<AdapterRouteClusterTitle.ViewHolder> {
    private Context context;
    private List<RoutePlaneData> routePlaneData;
    public static final int MAX_PLOT = 3;

    public AdapterRouteClusterTitle(Context context, List<RoutePlaneData> routePlaneData) {
        this.context = context;
        this.routePlaneData = routePlaneData;
        Log.d("AdapterRouteClusterTitle", "Data size: " + routePlaneData.size());
        if (!routePlaneData.isEmpty()) {
            Log.d("AdapterRouteClusterTitle", "Cluster size: " + routePlaneData.get(0).getClusters().size());
        }
    }

    @NonNull
    @Override
    public AdapterRouteClusterTitle.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_title_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRouteClusterTitle.ViewHolder holder, int position) {
        Log.d("positionSize: ", position + " / Total: " + getItemCount());
        if (position < routePlaneData.get(0).getClusters().size()) {
            holder.tvClusterMainTitle.setText("Cluster " + (position + 1));
        } else {
            Log.w("AdapterRouteClusterTitle", "Invalid position: " + position);
        }
    }

    @Override
    public int getItemCount() {
        int itemCount = (routePlaneData != null && !routePlaneData.isEmpty()) ?
                routePlaneData.get(0).getClusters().size() : 0;
        Log.d("AdapterRouteClusterTitle", "Item count: " + itemCount);
//        return itemCount;
        return MAX_PLOT;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvClusterMainTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClusterMainTitle = itemView.findViewById(R.id.tvClusterMainTitle);
        }
    }
}
