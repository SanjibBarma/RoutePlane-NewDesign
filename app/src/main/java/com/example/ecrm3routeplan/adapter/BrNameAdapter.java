package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class BrNameAdapter extends RecyclerView.Adapter<BrNameAdapter.ViewHolder> {
    Context context;
    List<RoutePlaneData> routePlaneData;

    public BrNameAdapter(Context context, List<RoutePlaneData> routePlaneData) {
        this.context = context;
        this.routePlaneData = routePlaneData;
    }

    @NonNull
    @Override
    public BrNameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.route_plane_br_name_child, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrNameAdapter.ViewHolder holder, int position) {
        RoutePlaneData data = routePlaneData.get(position);
        holder.tvBrName.setText(data.getName());
        holder.cbNameChildItem.setChecked(data.getIsAssigned() && data.isChecked());

        holder.cbNameChildItem.setEnabled(data.getIsAssigned());

        holder.cbNameChildItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (data.getIsAssigned()) {
                data.setChecked(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return routePlaneData.size();
    }

    public void selectAllAssigned(boolean isChecked) {
        for (RoutePlaneData data : routePlaneData) {
            if (data.getIsAssigned()) {
                data.setChecked(isChecked);
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrName;
        CheckBox cbNameChildItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrName = itemView.findViewById(R.id.tvBrName);
            cbNameChildItem = itemView.findViewById(R.id.cbNameChildItem);
        }
    }
}
