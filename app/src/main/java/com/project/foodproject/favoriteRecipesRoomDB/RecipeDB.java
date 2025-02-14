package com.project.foodproject.favoriteRecipesRoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.project.foodproject.Converters;

@Database(entities = {FavoriteDataModel.class}, version = 6)
@TypeConverters({Converters.class})
public abstract class RecipeDB extends RoomDatabase {
    private static RecipeDB INSTANCE;

    public abstract RecipeDao recipeDao();

    public static synchronized RecipeDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RecipeDB.class, "app_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
