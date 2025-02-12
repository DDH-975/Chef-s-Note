package com.project.foodproject.recyclerView_Dish_Itmes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.foodproject.R;
import com.project.foodproject.RecipeActivity;

import java.util.ArrayList;

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


    }

    @Override
    public int getItemCount() {
        return (null != dataModels ? dataModels.size() : 0);
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tv_foodName;
        ImageView img_foodImage;
        Button btn_showRecipe;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tv_foodName = itemView.findViewById(R.id.tv_foodName);
            img_foodImage = itemView.findViewById(R.id.img_foodImage);
            btn_showRecipe = itemView.findViewById(R.id.btn_showRecipe);
        }
    }
}
