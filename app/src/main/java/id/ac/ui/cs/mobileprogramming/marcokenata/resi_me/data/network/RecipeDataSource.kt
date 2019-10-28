package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Categories
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryParent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.DataResponse
import retrofit2.await
import javax.inject.Inject

@Module
class RecipeDataSource @Inject constructor( private val mealDBService: MealDBService) {

    private val _mealById = MutableLiveData<DataResponse>()

    val mealById: LiveData<DataResponse>
        get() = _mealById

    private val _mealByRandom = MutableLiveData<DataResponse>()

    val mealByRandom : LiveData<DataResponse>
        get() = _mealByRandom

    private val _mealByCategory = MutableLiveData<CategoryParent>()

    val mealByCategory : LiveData<CategoryParent>
        get() = _mealByCategory

    private val _categories = MutableLiveData<Categories>()

    val categories : LiveData<Categories>
        get() = _categories

    @Provides
    suspend fun getMealById(int: Int){
        val fetchedGetMealById = mealDBService
            .getMealByID(int)
            .await()

        _mealById.postValue(fetchedGetMealById)
    }

    @Provides
    suspend fun getMealByRandom(){
        val fetchedGetMealByRandom = mealDBService
            .getMealByRandom()
            .await()

        _mealByRandom.postValue(fetchedGetMealByRandom)
    }

    @Provides
    suspend fun getMealByCategory(category : String){
        val fetchedMealByCategory = mealDBService
            .getMealByCategory(category)
            .await()

        _mealByCategory.postValue(fetchedMealByCategory)
    }

    @Provides
    suspend fun getCategories(){
        val fetchCategories = mealDBService
            .getCategories()
            .await()

        _categories.postValue(fetchCategories)
    }

}