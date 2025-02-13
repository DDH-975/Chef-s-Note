package com.project.foodproject.recyclerView_Recipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project.foodproject.R;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.Viewholder> {
    private ArrayList<String> ManualList;
    private ArrayList<String> ManualImgList;

    public RecipeAdapter(ArrayList<String> ManualList, ArrayList<String> ManualImgList) {
        this.ManualList = ManualList;
        this.ManualImgList = ManualImgList;

    }

    @NonNull
    @Override
    public RecipeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        Viewholder holder = new Viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.Viewholder holder, int position) {
        String Url = ManualImgList.get(position);
        String manual = ManualList.get(position);

        Glide.with(holder.itemView.getContext()).
                load(Url).
                into(holder.img_manualImge);

        String formattedManual = manual.replace("\n", " ");

        holder.tv_manual.setText(formattedManual);
    }


    @Override
    public int getItemCount() {
        return (null != ManualList ? ManualList.size() : 0);
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView img_manualImge;
        TextView tv_manual;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img_manualImge = (ImageView) itemView.findViewById(R.id.img_manualImge);
            tv_manual = (TextView) itemView.findViewById(R.id.tv_manual);

        }
    }

}