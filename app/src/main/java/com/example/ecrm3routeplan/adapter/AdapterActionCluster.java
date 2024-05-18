package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.MainActivity;
import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class AdapterActionCluster extends RecyclerView.Adapter<AdapterActionCluster.ViewHolder> {
    Context context;
    List<RoutePlaneData> routePlaneData;

    public AdapterActionCluster(Context context, List<RoutePlaneData> routePlaneData) {
        this.context = context;
        this.routePlaneData = routePlaneData;
    }

    @NonNull
    @Override
    public AdapterActionCluster.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= (View) LayoutInflater.from(context).inflate(R.layout.list_action_button_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterActionCluster.ViewHolder holder, int position) {
        holder.ivActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return routePlaneData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivActionButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivActionButton = itemView.findViewById(R.id.ivActionButton);
        }
    }
}
