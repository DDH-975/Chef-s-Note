package com.project.foodproject.recyclerView;

import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerDataModel {
    private String url_foodImage;
    private String tv_foodName;


    public RecyclerDataModel(String url_foodImage, String tv_foodName){
        this.url_foodImage = url_foodImage;
        this.tv_foodName = tv_foodName;
    }

    public String getUrl_foodImage() {
        return url_foodImage;
    }

    public void setUrl_foodImage(String url_foodImage) {
        this.url_foodImage = url_foodImage;
    }

    public String getTv_foodName() {
        return tv_foodName;
    }

    public void setTv_foodName(String tv_foodName) {
        this.tv_foodName = tv_foodName;
    }
}
