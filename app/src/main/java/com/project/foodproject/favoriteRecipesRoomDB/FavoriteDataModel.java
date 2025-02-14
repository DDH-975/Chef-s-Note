package com.project.foodproject.favoriteRecipesRoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.project.foodproject.Converters;

import java.util.ArrayList;

@Entity
public class FavoriteDataModel {
    private String dishName;
    private String url_foodImage;
    private String RCP_PARTS_DTLS;

    @TypeConverters(Converters.class)
    private ArrayList<String> ManualList = new ArrayList<>();

    @TypeConverters(Converters.class)
    private ArrayList<String> ManualImgList = new ArrayList<>();


    @PrimaryKey(autoGenerate = true)
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getUrl_foodImage() {
        return url_foodImage;
    }

    public void setUrl_foodImage(String url_foodImage) {
        this.url_foodImage = url_foodImage;
    }

    public String getRCP_PARTS_DTLS() {
        return RCP_PARTS_DTLS;
    }

    public void setRCP_PARTS_DTLS(String RCP_PARTS_DTLS) {
        this.RCP_PARTS_DTLS = RCP_PARTS_DTLS;
    }

    public ArrayList<String> getManualList() {
        return ManualList;
    }

    public void setManualList(ArrayList<String> manualList) {
        ManualList = manualList;
    }

    public ArrayList<String> getManualImgList() {
        return ManualImgList;
    }

    public void setManualImgList(ArrayList<String> manualImgList) {
        ManualImgList = manualImgList;
    }
}


