package com.project.foodproject;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataClass {
    private CookRcp COOKRCP01;

    public CookRcp getCOOKRCP01() {
        return COOKRCP01;
    }

    public void setCOOKRCP01(CookRcp COOKRCP01) {
        this.COOKRCP01 = COOKRCP01;
    }

    public static class CookRcp {
        private String total_count;
        private List<Row> row;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public List<DataClass.Row> getRow() {
            return row;
        }

        public void setRow(List<DataClass.Row> row) {
            this.row = row;
        }
    }

    public static class Row {
        private String RCP_PARTS_DTLS; //재료정보
        private String RCP_WAY2; // 조리방법
        private String RCP_NM; //메뉴명
        private String RCP_PAT2;//	요리종류 ex)반찬, 밥

        @SerializedName("ATT_FILE_NO_MAIN")
        private String foodSmailImage;

        @SerializedName("ATT_FILE_NO_MK")
        private String foodBigImage;

        private String MANUAL01;
        private String MANUAL02;
        private String MANUAL03;
        private String MANUAL04;
        private String MANUAL05;
        private String MANUAL06;
        private String MANUAL07;
        private String MANUAL08;
        private String MANUAL09;
        private String MANUAL10;
        private String MANUAL11;
        private String MANUAL12;
        private String MANUAL13;
        private String MANUAL14;
        private String MANUAL15;
        private String MANUAL16;
        private String MANUAL17;
        private String MANUAL18;
        private String MANUAL19;
        private String MANUAL20;

        private String MANUAL_IMG01;
        private String MANUAL_IMG02;
        private String MANUAL_IMG03;
        private String MANUAL_IMG04;
        private String MANUAL_IMG05;
        private String MANUAL_IMG06;
        private String MANUAL_IMG07;
        private String MANUAL_IMG08;
        private String MANUAL_IMG09;
        private String MANUAL_IMG10;
        private String MANUAL_IMG11;
        private String MANUAL_IMG12;
        private String MANUAL_IMG13;
        private String MANUAL_IMG14;
        private String MANUAL_IMG15;
        private String MANUAL_IMG16;
        private String MANUAL_IMG17;
        private String MANUAL_IMG18;
        private String MANUAL_IMG19;
        private String MANUAL_IMG20;

        private ArrayList<String> ManualList = new ArrayList<>(); //메뉴얼 리스트
        private ArrayList<String> ManualImgList = new ArrayList<>(); // 메뉴얼 이미지 리스트

        public String getRCP_PARTS_DTLS() {
            return RCP_PARTS_DTLS;
        }

        public void setRCP_PARTS_DTLS(String RCP_PARTS_DTLS) {
            this.RCP_PARTS_DTLS = RCP_PARTS_DTLS;
        }

        public String getRCP_WAY2() {
            return RCP_WAY2;
        }

        public void setRCP_WAY2(String RCP_WAY2) {
            this.RCP_WAY2 = RCP_WAY2;
        }

        public String getRCP_NM() {
            return RCP_NM;
        }

        public void setRCP_NM(String RCP_NM) {
            this.RCP_NM = RCP_NM;
        }

        public String getRCP_PAT2() {
            return RCP_PAT2;
        }

        public void setRCP_PAT2(String RCP_PAT2) {
            this.RCP_PAT2 = RCP_PAT2;
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

        public String getFoodSmailImage() {
            return foodSmailImage;
        }

        public void setFoodSmailImage(String foodSmailImage) {
            this.foodSmailImage = foodSmailImage;
        }

        public String getFoodBigImage() {
            return foodBigImage;
        }

        public void setFoodBigImage(String foodBigImage) {
            this.foodBigImage = foodBigImage;
        }

        public String getMANUAL01() {
            return MANUAL01;
        }

        public String getMANUAL02() {
            return MANUAL02;
        }

        public String getMANUAL03() {
            return MANUAL03;
        }

        public String getMANUAL04() {
            return MANUAL04;
        }

        public String getMANUAL05() {
            return MANUAL05;
        }

        public String getMANUAL06() {
            return MANUAL06;
        }

        public String getMANUAL07() {
            return MANUAL07;
        }

        public String getMANUAL08() {
            return MANUAL08;
        }

        public String getMANUAL09() {
            return MANUAL09;
        }

        public String getMANUAL10() {
            return MANUAL10;
        }

        public String getMANUAL11() {
            return MANUAL11;
        }

        public String getMANUAL12() {
            return MANUAL12;
        }

        public String getMANUAL13() {
            return MANUAL13;
        }

        public String getMANUAL14() {
            return MANUAL14;
        }

        public String getMANUAL15() {
            return MANUAL15;
        }

        public String getMANUAL16() {
            return MANUAL16;
        }

        public String getMANUAL17() {
            return MANUAL17;
        }

        public String getMANUAL18() {
            return MANUAL18;
        }

        public String getMANUAL19() {
            return MANUAL19;
        }

        public String getMANUAL20() {
            return MANUAL20;
        }

        public String getMANUAL_IMG01() {
            return MANUAL_IMG01;
        }

        public String getMANUAL_IMG02() {
            return MANUAL_IMG02;
        }

        public String getMANUAL_IMG03() {
            return MANUAL_IMG03;
        }

        public String getMANUAL_IMG04() {
            return MANUAL_IMG04;
        }

        public String getMANUAL_IMG05() {
            return MANUAL_IMG05;
        }

        public String getMANUAL_IMG06() {
            return MANUAL_IMG06;
        }

        public String getMANUAL_IMG07() {
            return MANUAL_IMG07;
        }

        public String getMANUAL_IMG08() {
            return MANUAL_IMG08;
        }

        public String getMANUAL_IMG09() {
            return MANUAL_IMG09;
        }

        public String getMANUAL_IMG10() {
            return MANUAL_IMG10;
        }

        public String getMANUAL_IMG11() {
            return MANUAL_IMG11;
        }

        public String getMANUAL_IMG12() {
            return MANUAL_IMG12;
        }

        public String getMANUAL_IMG13() {
            return MANUAL_IMG13;
        }

        public String getMANUAL_IMG14() {
            return MANUAL_IMG14;
        }

        public String getMANUAL_IMG15() {
            return MANUAL_IMG15;
        }

        public String getMANUAL_IMG16() {
            return MANUAL_IMG16;
        }

        public String getMANUAL_IMG17() {
            return MANUAL_IMG17;
        }

        public String getMANUAL_IMG18() {
            return MANUAL_IMG18;
        }

        public String getMANUAL_IMG19() {
            return MANUAL_IMG19;
        }

        public String getMANUAL_IMG20() {
            return MANUAL_IMG20;
        }

        public void addManual(String munual) {
            if (munual != null && !munual.isEmpty()) {
                ManualList.add(munual);
            }
        }

        public void addManualImg(String munualImg) {
            if (munualImg != null && !munualImg.isEmpty()) {
                ManualImgList.add(munualImg);
            }
        }
    }
}