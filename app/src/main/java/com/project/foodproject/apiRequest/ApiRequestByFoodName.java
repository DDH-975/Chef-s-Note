package com.project.foodproject.apiRequest;

import android.util.Log;

import com.google.gson.Gson;
import com.project.foodproject.ApiService;
import com.project.foodproject.DataClass;
import com.project.foodproject.recyclerView_Dish_Itmes.RecyclerDataModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequestByFoodName {
    private String ApiKey;
    private String serviceId;
    private String dataType;
    private String startIdx;
    private String endIdx;
    private String foodName;
    private ApiService apiService;
    private ApiCallbackByFoodName callback;

    public interface ApiCallbackByFoodName {
        void onDataReceived(List<RecyclerDataModel> dataModelList);
    }

    public ApiRequestByFoodName(String apiKey, String serviceId, String dataType, String startIdx,
                                String endIdx, String foodName, ApiService apiService, ApiCallbackByFoodName callback) {
        this.ApiKey = apiKey;
        this.serviceId = serviceId;
        this.dataType = dataType;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.foodName = foodName;
        this.apiService = apiService;
        this.callback = callback;
    }

    public void requestByFoodName() {
        apiService.getRecipesByFoodName(ApiKey, serviceId, dataType, startIdx, endIdx, foodName).enqueue(new Callback<DataClass>() {
            @Override
            public void onResponse(Call<DataClass> call, Response<DataClass> response) {
                if (response.isSuccessful()) {
                    Log.i("onResponse", "API 호출 성공");
                    DataClass dataClass = response.body();
                    if (dataClass != null) {
                        List<RecyclerDataModel> dataModels = new ArrayList<>();
                        for (DataClass.Row row : dataClass.getCOOKRCP01().getRow()) {
                            try {
                                JSONObject jsonObject = new JSONObject(new Gson().toJson(row));
                                for (int i = 1; i <= 20; i++) {
                                    String manualKey = "MANUAL" + String.format("%02d", i);
                                    String manualImgKey = "MANUAL_IMG" + String.format("%02d", i);

                                    String manual = jsonObject.optString(manualKey);
                                    String manualImg = jsonObject.optString(manualImgKey);


                                    if (manual != null && !manual.isEmpty()) {
                                        row.addManual(manual);
                                    }
                                    if (manualImg != null && !manualImg.isEmpty()) {
                                        row.addManualImg(manualImg);
                                    }
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            RecyclerDataModel dataModel = new RecyclerDataModel(row.getFoodSmailImage(), row.getRCP_NM(), row.getRCP_PARTS_DTLS(),
                                    row.getManualList(), row.getManualImgList());
                            dataModels.add(dataModel);
                        }
                        callback.onDataReceived(dataModels);
                    } else {
                        Log.w("onResponse", "데이터가 null입니다.");
                    }
                } else {
                    Log.e("onResponse", "API 호출 실패: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t) {
                Log.e("onFailure", "api 호출 실패" + t.getStackTrace());
            }
        });
    }


}
