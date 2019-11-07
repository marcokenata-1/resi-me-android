package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Categories
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.DataResponse
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val getRandom = MutableLiveData<DataResponse>()

    val getCategory = MutableLiveData<Categories>()

    init {
        launch {
            getRandom.value = recipeRepository.fetchGetMealByRandom().value
            getCategory.value = recipeRepository.fetchCategories().value
        }
    }



}
