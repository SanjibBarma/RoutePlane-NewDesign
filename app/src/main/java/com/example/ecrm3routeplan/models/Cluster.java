package com.example.ecrm3routeplan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cluster implements Serializable {
    @SerializedName("route_id")
    @Expose
    private Object routeId;
    @SerializedName("route_name")
    @Expose
    private Object routeName;
    @SerializedName("cluster_id")
    @Expose
    private Object clusterId;
    @SerializedName("cluster_name")
    @Expose
    private Object clusterName;

    public Object getRouteId() {
        return routeId;
    }

    public void setRouteId(Object routeId) {
        this.routeId = routeId;
    }

    public Object getRouteName() {
        return routeName;
    }

    public void setRouteName(Object routeName) {
        this.routeName = routeName;
    }

    public Object getClusterId() {
        return clusterId;
    }

    public void setClusterId(Object clusterId) {
        this.clusterId = clusterId;
    }

    public Object getClusterName() {
        return clusterName;
    }

    public void setClusterName(Object clusterName) {
        this.clusterName = clusterName;
    }
}
