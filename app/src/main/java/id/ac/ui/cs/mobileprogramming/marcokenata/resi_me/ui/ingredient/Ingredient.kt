package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.ingredient

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import dagger.android.support.AndroidSupportInjection

import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.IngredientFragmentBinding
import kotlinx.android.synthetic.main.ingredient_fragment.*
import javax.inject.Inject

class Ingredient : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: IngredientViewModelFactory

    private lateinit var viewModel: IngredientViewModel

    private lateinit var binding: IngredientFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.ingredient_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(IngredientViewModel::class.java)
        val intent = activity?.intent?.extras
        val idMeal = intent?.get("idMeal").toString().toInt()
        viewModel.getId(idMeal)

        viewModel.recipeLiveData.observe(this, Observer {value ->
            binding.recipe = value
            if (tv_ingredient_3.text == "" || tv_ingredient_3.text == "null"){
                tv_ingredient_3.visibility = View.GONE
            }
            if (tv_ingredient_4.text == "" || tv_ingredient_4.text == "null"){
                tv_ingredient_4.visibility = View.GONE
            }
            if (tv_ingredient_5.text == "" || tv_ingredient_5.text == "null"){
                tv_ingredient_5.visibility = View.GONE
            }
            if (tv_ingredient_6.text == ""|| tv_ingredient_6.text == "null"){
                tv_ingredient_6.visibility = View.GONE
            }
            if (tv_ingredient_7.text == ""|| tv_ingredient_7.text == "null"){
                tv_ingredient_7.visibility = View.GONE
            }
            if (tv_ingredient_8.text == ""|| tv_ingredient_8.text == "null"){
                tv_ingredient_8.visibility = View.GONE
            }
            if (tv_ingredient_9.text == ""|| tv_ingredient_9.text == "null"){
                tv_ingredient_9.visibility = View.GONE
            }
            if (tv_ingredient_10.text == ""|| tv_ingredient_10.text == "null"){
                tv_ingredient_10.visibility = View.GONE
            }
            if (tv_ingredient_11.text == ""|| tv_ingredient_11.text == "null"){
                tv_ingredient_11.visibility = View.GONE
            }
            if (tv_ingredient_12.text == ""|| tv_ingredient_12.text == "null"){
                tv_ingredient_12.visibility = View.GONE
            }
            if (tv_ingredient_13.text == ""|| tv_ingredient_13.text == "null"){
                tv_ingredient_13.visibility = View.GONE
            }
            if (tv_ingredient_14.text == ""|| tv_ingredient_14.text == "null"){
                tv_ingredient_14.visibility = View.GONE
            }
            if (tv_ingredient_15.text == ""|| tv_ingredient_15.text == "null"){
                tv_ingredient_15.visibility = View.GONE
            }
            if (tv_ingredient_16.text == ""|| tv_ingredient_16.text == "null"){
                tv_ingredient_16.visibility = View.GONE
            }
            if (tv_ingredient_17.text == ""|| tv_ingredient_17.text == "null"){
                tv_ingredient_17.visibility = View.GONE
            }
            if (tv_ingredient_18.text == ""|| tv_ingredient_18.text == "null"){
                tv_ingredient_18.visibility = View.GONE
            }
            if (tv_ingredient_19.text == ""|| tv_ingredient_19.text == "null"){
                tv_ingredient_19.visibility = View.GONE
            }
            if (tv_ingredient_20.text == ""|| tv_ingredient_20.text == "null"){
                tv_ingredient_20.visibility = View.GONE
            }
            bt_lets_cook.setOnClickListener {
                val action =
                    IngredientDirections
                        .actionIngredientToCookingStep2()
                view?.findNavController()?.navigate(action)
            }
        })
    }

}
