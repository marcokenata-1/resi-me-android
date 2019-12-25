package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.savedrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.RecipeAdapter
import kotlinx.android.synthetic.main.saved_menu_fragment.*
import javax.inject.Inject

class SavedMenu : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: SavedMenuViewModelFactory

    private lateinit var viewModel: SavedMenuViewModel

    var adapter : RecipeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.saved_menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(SavedMenuViewModel::class.java)

        if (viewModel.savedRecipes.value?.size != 0){
            viewModel.savedRecipes.observe(this, Observer{ value ->
                adapter = RecipeAdapter(context,value)
                lv_recipes.adapter = adapter
            })
        }
    }

}
