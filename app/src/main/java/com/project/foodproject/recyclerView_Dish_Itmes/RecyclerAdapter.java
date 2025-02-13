package com.project.foodproject.recyclerView_Dish_Itmes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.foodproject.R;
import com.project.foodproject.RecipeActivity;
import com.project.foodproject.favoriteRecipesRoomDB.FavoriteDataModel;
import com.project.foodproject.favoriteRecipesRoomDB.RecipeDB;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder> {
    private ArrayList<RecyclerDataModel> dataModels;


    public RecyclerAdapter(ArrayList<RecyclerDataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public RecyclerAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dish, parent, false);
        Viewholder holder = new Viewholder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Viewholder holder, int position) {
        String foodName = dataModels.get(position).getTv_foodName();
        String imgUrl = dataModels.get(position).getUrl_foodImage();
        String RCP_PARTS_DTLS = dataModels.get(position).getRCP_PARTS_DTLS();
        ArrayList<String> ManualList = dataModels.get(position).getManualList();
        ArrayList<String> ManualImgList = dataModels.get(position).getManualImgList();

        FavoriteDataModel dataModel = new FavoriteDataModel();
        RecipeDB recipeDB = RecipeDB.getInstance(holder.itemView.getContext());


        holder.tv_foodName.setText(foodName);
        Glide.with(holder.itemView.getContext())
                .load(imgUrl)
                .into(holder.img_foodImage);



        holder.btn_showRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), RecipeActivity.class);
                intent.putExtra("foodName", foodName);
                intent.putExtra("RCP_PARTS_DTLS", RCP_PARTS_DTLS);
                intent.putStringArrayListExtra("ManualList", ManualList);
                intent.putStringArrayListExtra("ManualImgList", ManualImgList);

                holder.itemView.getContext().startActivity(intent);
            }
        });


        checkIfFavorite(dataModel, recipeDB, foodName, holder.itemView.getContext(), holder.CB_favorites);


        holder.CB_favorites.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    handleCheckBoxChecked(dataModel, recipeDB, foodName, holder.itemView.getContext());

                } else if (b == false) {
                    handleCheckBoxUnchecked(recipeDB, foodName, holder.itemView.getContext());
                }
            }
        });

    }


    // 해당 레시피가 이미 즐겨찾기에 추가되어 있는지 확인하는 메서드
    private void checkIfFavorite(FavoriteDataModel dataModel, RecipeDB data,
                                       String nickname, Context context, CheckBox checkBox){
        dataModel.setDishName(nickname);
        new Thread(() -> {
            if (data.recipeDao().isRecipeExists(dataModel.getDishName()) > 0) {
                ((AppCompatActivity) context).runOnUiThread(() ->
                        checkBox.setChecked(true)
                );
            } else {
                ((AppCompatActivity) context).runOnUiThread(() ->
                        checkBox.setChecked(false)
                );
            }

            List<FavoriteDataModel> allRecipe = data.recipeDao().getAllDataSortedByDishName();
            for (FavoriteDataModel Recipe : allRecipe) {
                Log.d("DB_Check", "dishName : "+Recipe.getDishName() );
            }

        }).start();

    }


    //roomDB에 즐겨찾기 레시피추가
    private void handleCheckBoxChecked(FavoriteDataModel dataModel, RecipeDB data,
                                       String nickname, Context context) {
        dataModel.setDishName(nickname);
        Log.d("PlayerDataModel", "Nickname: " + dataModel.getDishName());

        new Thread(() -> {
            if (data.recipeDao().isRecipeExists(dataModel.getDishName()) == 0) {
                data.recipeDao().setInsertFavoriteRecipe(dataModel);
            }

            List<FavoriteDataModel> allRecipe = data.recipeDao().getAllDataSortedByDishName();
            for (FavoriteDataModel Recipe : allRecipe) {
                Log.d("DB_Check", "dishName : "+Recipe.getDishName() );
            }

        }).start();

    }

    //roomDB에 즐겨찾기 레시피 삭제
    private void handleCheckBoxUnchecked(RecipeDB recipeDB, String dishName, Context context) {
        new Thread(() -> {
            try {
                recipeDB.recipeDao().deleteRecipeByDishName(dishName);

                List<FavoriteDataModel> allRecipe = recipeDB.recipeDao().getAllDataSortedByDishName();
                for (FavoriteDataModel recipe : allRecipe) {
                    Log.d("DB_Check", "dishName: " +recipe.getDishName());
                }
                ((AppCompatActivity) context).runOnUiThread(() ->
                        Toast.makeText(context, dishName + " 삭제되었습니다", Toast.LENGTH_SHORT).show()
                );
            } catch (Exception e) {
                Log.e("checked Room Data", "no data at room");
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        return (null != dataModels ? dataModels.size() : 0);
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tv_foodName;
        ImageView img_foodImage;
        Button btn_showRecipe;
        CheckBox CB_favorites;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_foodName = itemView.findViewById(R.id.tv_foodName);
            img_foodImage = itemView.findViewById(R.id.img_foodImage);
            btn_showRecipe = itemView.findViewById(R.id.btn_showRecipe);
            CB_favorites = itemView.findViewById(R.id.CB_favorites);
        }
    }
}
