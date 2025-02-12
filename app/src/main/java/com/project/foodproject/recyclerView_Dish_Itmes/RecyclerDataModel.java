package com.project.foodproject.recyclerView_Dish_Itmes;

import java.util.ArrayList;

public class RecyclerDataModel {
    private String url_foodImage;
    private String tv_foodName;
    private String RCP_PARTS_DTLS;
    private ArrayList<String> ManualList = new ArrayList<>();
    private ArrayList<String> ManualImgList = new ArrayList<>();


    public RecyclerDataModel(String url_foodImage, String tv_foodName, String RCP_PARTS_DTLS,
                             ArrayList<String> ManualList, ArrayList<String> ManualImgList) {

        this.url_foodImage = url_foodImage;
        this.tv_foodName = tv_foodName;
        this.RCP_PARTS_DTLS = RCP_PARTS_DTLS;
        this.ManualList = ManualList;
        this.ManualImgList = ManualImgList;
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
