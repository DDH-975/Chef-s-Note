package com.project.foodproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.foodproject.apiRequest.ApiRequestByCategory;
import com.project.foodproject.apiRequest.ApiRequestByFoodName;
import com.project.foodproject.recyclerView_Dish_Itmes.RecyclerAdapter;
import com.project.foodproject.recyclerView_Dish_Itmes.RecyclerDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class ShowFoodItems extends AppCompatActivity {
    private final String ApiKey = BuildConfig.Apikey;
    private final String serviceId = "COOKRCP01";
    private final String dataType = "json";
    private final String startIdx = "1";
    private final String endIdx = "100";
    private Retrofit retrofit;
    private ApiService apiService;
    private RecyclerView recyclerView;
    private ArrayList<RecyclerDataModel> recyclerDataModels;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_food_items);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        String apiMode = intent.getStringExtra("apiMode");
        Log.d("getIntentData", "data : " + data + "\n" + "apiMode: " + apiMode);

        retrofit = NetworkClient.getRetrofitClient(ShowFoodItems.this);
        apiService = retrofit.create(ApiService.class);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerDataModels = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(recyclerDataModels);
        recyclerView.setAdapter(recyclerAdapter);


        if (apiMode.equals("category")) {
            Log.i("콜백 및 api 요청 순서 테스트","1");
            ApiRequestByCategory requestByCategory = new ApiRequestByCategory(ApiKey, serviceId, dataType,
                    startIdx, endIdx, data, apiService, new ApiRequestByCategory.ApiCallbackByCategory() {
                @Override
                public void onDataReceived(List<RecyclerDataModel> data) {
                    Log.i("콜백 및 api 요청 순서 테스트","3");
                    recyclerDataModels.clear();
                    Log.i("콜백 및 api 요청 순서 테스트","4");
                    recyclerDataModels.addAll(data);
                    Log.i("콜백 및 api 요청 순서 테스트","5");
                    recyclerAdapter.notifyDataSetChanged();
                }
            });
            Log.i("콜백 및 api 요청 순서 테스트","2");
            requestByCategory.requestByCategory();

        } else if (apiMode.equals("foodname")) {
            ApiRequestByFoodName requestByFoodName = new ApiRequestByFoodName(ApiKey, serviceId, dataType,
                    startIdx, endIdx, data, apiService, new ApiRequestByFoodName.ApiCallbackByFoodName() {
                @Override
                public void onDataReceived(List<RecyclerDataModel> dataModelList) {
                    recyclerDataModels.clear();
                    recyclerDataModels.addAll(dataModelList);
                    recyclerAdapter.notifyDataSetChanged();
                }
            });
            requestByFoodName.requestByFoodName();
        }




    }
}