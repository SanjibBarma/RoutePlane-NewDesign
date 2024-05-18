package com.example.ecrm3routeplan.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;


public class AdapterBrName extends RecyclerView.Adapter<AdapterBrName.ViewHolder> {

    Context context;
    List<RoutePlaneData> data;

    public AdapterBrName(Context context, List<RoutePlaneData> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.route_plane_br_name_child,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvBrName.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrName = itemView.findViewById(R.id.tvBrName);
        }
    }
}
