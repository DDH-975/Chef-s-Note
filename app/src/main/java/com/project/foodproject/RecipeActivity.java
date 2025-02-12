package com.project.foodproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.foodproject.recyclerView_Recipe.RecipeAdapter;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {
    private TextView tv_food, tv_ingredients;
    private RecyclerView rv_recipe;
    private LinearLayoutManager linearLayoutManager;
    private RecipeAdapter adapter;
    private ArrayList<String> ManualList = new ArrayList<>();
    private ArrayList<String> ManualImgList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipe);

        tv_food = (TextView) findViewById(R.id.tv_food);
        tv_ingredients = (TextView) findViewById(R.id.tv_ingredients);
        rv_recipe = (RecyclerView) findViewById(R.id.rv_recipe);

        Intent intent = getIntent();
        String foodNmae = intent.getStringExtra("foodName");
        String RCP_PARTS_DTLS = intent.getStringExtra("RCP_PARTS_DTLS");

        tv_food.setText(foodNmae);
        tv_ingredients.setText(RCP_PARTS_DTLS);

        ManualList = intent.getStringArrayListExtra("ManualList");
        ManualImgList = intent.getStringArrayListExtra("ManualImgList");

        linearLayoutManager = new LinearLayoutManager(this);
        rv_recipe.setLayoutManager(linearLayoutManager);

        adapter = new RecipeAdapter(ManualList, ManualImgList);
        rv_recipe.setAdapter(adapter);

    }
}