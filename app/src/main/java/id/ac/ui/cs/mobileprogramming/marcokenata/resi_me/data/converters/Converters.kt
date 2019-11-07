package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Meals
import com.google.gson.reflect.TypeToken




object Converters {
    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: String): Any? {
        val listType = object : TypeToken<ArrayList<String>>() {

        }.type
        return Gson().fromJson(value, listType)
        // return value == null ? null : new Date(value);
    }

    @TypeConverter
    @JvmStatic
    fun fromMeals(value: String): ArrayList<Int> {
        val listType = object : TypeToken<ArrayList<Int>>() {

        }.type
        return Gson().fromJson(value, listType)
        // return value == null ? null : new Date(value);
    }

    @TypeConverter
    @JvmStatic
    fun mealsToString(meals: Meals): String {
        val gson = Gson()
        return gson.toJson(meals)
    }

    @TypeConverter
    @JvmStatic
    fun arraylistNumberToString(list: ArrayList<Int>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    @JvmStatic
    fun stringtoMeals(value:String): Meals {
        val listType = object : TypeToken<Meals>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun arraylistMealsToString(list: ArrayList<Meals>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    @JvmStatic
    fun stringtoArraylistMeals(value: String) : ArrayList<Meals> {
        val listType = object : TypeToken<ArrayList<Meals>>() {

        }.type
        return Gson().fromJson(value, listType)
    }
}