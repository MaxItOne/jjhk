package com.example.recycleview_viewpager;

import java.io.Serializable;

public class User implements Serializable {
    private int resourceId;
    private String name;
    private String adress;

    public User(int resourceId, String name, String adress) {
        this.resourceId = resourceId;
        this.name = name;
        this.adress = adress;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
