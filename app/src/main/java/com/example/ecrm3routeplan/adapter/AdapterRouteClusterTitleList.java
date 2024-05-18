package com.example.ecrm3routeplan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ecrm3routeplan.MainActivity;
import com.example.ecrm3routeplan.R;
import com.example.ecrm3routeplan.models.RoutePlaneData;

import java.util.List;

public class AdapterRouteClusterTitleList extends BaseAdapter {
    Context context;
    List<RoutePlaneData> routePlaneData;
    private LayoutInflater inflater;

    public AdapterRouteClusterTitleList(Context context, List<RoutePlaneData> routePlaneData) {
        this.context = context;
        this.routePlaneData = routePlaneData;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return routePlaneData.get(0).getClusters().size();
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
            convertView = inflater.inflate(R.layout.list_title_layout, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.tvClusterMainTitle);
        textView.setText("Cluster "+(position+1));
        return convertView;
    }
}
