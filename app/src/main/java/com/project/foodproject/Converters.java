package com.project.foodproject;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    private static Gson gson = new Gson();

    @TypeConverter
    public static String fromList(ArrayList<String> list) {
        return gson.toJson(list);  // 리스트 → JSON 문자열 변환
    }

    @TypeConverter
    public static ArrayList<String> toList(String json) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(json, listType);  // JSON 문자열 → 리스트 변환
    }
}
