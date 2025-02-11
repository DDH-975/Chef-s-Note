package com.project.foodproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

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
import com.project.foodproject.recyclerView.RecyclerAdapter;
import com.project.foodproject.recyclerView.RecyclerDataModel;

import java.util.ArrayList;

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
    private DataClass dataClass ;

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
            ApiRequestByCategory requestByCategory = new ApiRequestByCategory(ApiKey, serviceId, dataType,
                    startIdx, endIdx, data, apiService);
            requestByCategory.requestByCategory();
        } else if (apiMode.equals("foodname")) {
            ApiRequestByFoodName requestByFoodName = new ApiRequestByFoodName(ApiKey, serviceId, dataType,
                    startIdx, endIdx, data, apiService);
            requestByFoodName.requestByFoodName();
        }

//        for(DataClass.Row row : dataClass.getCOOKRCP01().getRow()){
//            RecyclerDataModel dataModel = new RecyclerDataModel(row.getFoodSmailImage(),row.getRCP_NM());
//            recyclerDataModels.add(0,dataModel);
//            recyclerAdapter.notifyDataSetChanged();
//        }


    }
}