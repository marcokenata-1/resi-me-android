package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryParent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.DataResponse
import retrofit2.await

class RecipeDataSource constructor( private val mealDBService: MealDBService) {

    private val _mealById = MutableLiveData<DataResponse>()

    val mealById: LiveData<DataResponse>
        get() = _mealById

    private val _mealByRandom = MutableLiveData<DataResponse>()

    val mealByRandom : LiveData<DataResponse>
        get() = _mealByRandom

    private val _mealByCategory = MutableLiveData<CategoryParent>()

    val mealByCategory : LiveData<CategoryParent>
        get() = _mealByCategory

    suspend fun getMealById(int: Int){
        val fetchedGetMealById = mealDBService
            .getMealByID(int)
            .await()

        _mealById.postValue(fetchedGetMealById)
    }

    suspend fun getMealByRandom(){
        val fetchedGetMealByRandom = mealDBService
            .getMealByRandom()
            .await()

        _mealByRandom.postValue(fetchedGetMealByRandom)
    }

    suspend fun getMealByCategory(category : String){
        val fetchedMealByCategory = mealDBService
            .getMealByCategory(category)
            .await()

        _mealByCategory.postValue(fetchedMealByCategory)
    }


}