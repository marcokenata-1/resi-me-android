package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network

import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Categories
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryParent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealDBService {

    @GET("lookup.php?")
    fun getMealByID(@Query("i") mealID : Int) : Call<DataResponse>

    @GET("random.php")
    fun getMealByRandom() : Call<DataResponse>

    @GET("filter.php?")
    fun getMealByCategory(@Query("c") mealCategory : String) : Call<CategoryParent>

    @GET("categories.php")
    fun getCategories() : Call<Categories>

}