package com.example.ecrm3routeplan.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cluster implements Serializable {
    @SerializedName("route_id")
    @Expose
    private Integer routeId;
    @SerializedName("route_name")
    @Expose
    private String routeName;
    @SerializedName("cluster_id")
    @Expose
    private Integer clusterId;
    @SerializedName("cluster_name")
    @Expose
    private String clusterName;

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
}
