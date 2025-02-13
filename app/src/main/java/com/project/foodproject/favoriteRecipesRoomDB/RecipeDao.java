package com.project.foodproject.favoriteRecipesRoomDB;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void setInsertFavoriteRecipe(FavoriteDataModel favoriteDataModel);

    @Update
    void setUpdateFavoriteRecipe(FavoriteDataModel favoriteDataModel);

    @Delete
    void setDeleteFavoriteRecipe(FavoriteDataModel playerDataModel);

    @Query("SELECT * FROM FavoriteDataModel ORDER BY dishName ASC")
    List<FavoriteDataModel> getAllDataSortedByDishName();

    @Query("DELETE FROM FavoriteDataModel WHERE dishName = :dishName")
    void deleteRecipeByDishName(String dishName);

    @Query("SELECT COUNT(*) FROM FavoriteDataModel WHERE dishName = :dishName")
    int isRecipeExists(String dishName);
}
