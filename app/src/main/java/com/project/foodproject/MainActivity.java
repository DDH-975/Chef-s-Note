package com.project.foodproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn_Rice_Dishes, btn_soup, btn_side_dish, btn_high_end_food, btn_dessert;
    private ImageButton btn_searchFood, btn_favorites;
    private EditText et_searchFood;
    private Intent intent;


    public void setDataIntent(String apiMode, String putDataAtIntent) {
        intent.putExtra("data", putDataAtIntent);
        intent.putExtra("apiMode", apiMode);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_Rice_Dishes = (Button) findViewById(R.id.btn_Rice_Dishes);
        btn_soup = (Button) findViewById(R.id.btn_soup);
        btn_side_dish = (Button) findViewById(R.id.btn_side_dish);
        btn_high_end_food = (Button) findViewById(R.id.btn_high_end_food);
        btn_dessert = (Button) findViewById(R.id.btn_dessert);
        btn_searchFood = (ImageButton) findViewById(R.id.btn_searchFood);
        et_searchFood = (EditText) findViewById(R.id.et_searchFood);
        btn_favorites = (ImageButton) findViewById(R.id.btn_favorites);

        String apiModeCategory = "category";
        String apiModeFoodName = "foodname";

        intent = new Intent(MainActivity.this, ShowFoodItems.class);

        btn_Rice_Dishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataIntent(apiModeCategory, "밥");
            }
        });

        btn_soup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataIntent(apiModeCategory, "국");
            }
        });

        btn_side_dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataIntent(apiModeCategory, "반찬");
            }
        });

        btn_dessert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataIntent(apiModeCategory, "후식");
            }
        });


        btn_high_end_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDataIntent(apiModeCategory, "일품");
            }
        });

        btn_searchFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et_searchFood.getText().toString();
                String noSpacesStr = str.replaceAll("\\s", "");
                setDataIntent(apiModeFoodName, noSpacesStr);
            }
        });


        Intent intent2 = new Intent(MainActivity.this, FavoriteRecipes.class);
        btn_favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });

    }
}