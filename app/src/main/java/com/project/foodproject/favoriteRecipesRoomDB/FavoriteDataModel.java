package com.project.foodproject.favoriteRecipesRoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class FavoriteDataModel {
    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String dishName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
}
