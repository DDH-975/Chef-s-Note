package com.project.foodproject;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.foodproject.favoriteRecipesRoomDB.FavoriteDataModel;
import com.project.foodproject.favoriteRecipesRoomDB.RecipeDB;
import com.project.foodproject.recyclerView_Dish_Itmes.RecyclerAdapter;
import com.project.foodproject.recyclerView_Dish_Itmes.RecyclerDataModel;

import java.util.ArrayList;
import java.util.List;


public class FavoriteRecipes extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<RecyclerDataModel> recyclerDataModels;
    private RecyclerAdapter recyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecipeDB recipeDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorite_recipes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = (RecyclerView) findViewById(R.id.rv_favorite);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recipeDB = RecipeDB.getInstance(this);

        recyclerDataModels = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(recyclerDataModels);
        recyclerView.setAdapter(recyclerAdapter);

        new Thread(() -> {
            List<FavoriteDataModel> DataModelsList = recipeDB.recipeDao().getAllDataSortedByDishName();

            new Handler(Looper.getMainLooper()).post(() -> {
                for (FavoriteDataModel data : DataModelsList) {
                    RecyclerDataModel favoritePlayer = new RecyclerDataModel(
                            data.getUrl_foodImage(), data.getDishName(),
                            data.getRCP_PARTS_DTLS(), data.getManualList(), data.getManualImgList()
                    );

                    recyclerDataModels.add(favoritePlayer);
                }
                recyclerAdapter.notifyDataSetChanged();
            });
        }).start();


    }
}