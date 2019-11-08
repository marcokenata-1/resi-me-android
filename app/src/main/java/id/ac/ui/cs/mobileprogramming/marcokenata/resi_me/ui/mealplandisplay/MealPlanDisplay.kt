package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplandisplay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.MealPlanRecipeAdapter
import kotlinx.android.synthetic.main.meal_plan_display_fragment.*
import javax.inject.Inject

class MealPlanDisplay : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: MealPlanDisplayViewModelFactory

    private lateinit var viewModel: MealPlanDisplayViewModel

    var adapter : MealPlanRecipeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.meal_plan_display_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MealPlanDisplayViewModel::class.java)

        val intent = activity?.intent?.extras
        val idMeal = intent?.get("idMealPlan").toString().toInt()

        viewModel.getPlan(idMeal)

        viewModel.mealPlanLiveData.observe(this, Observer { values ->
            tv_meal_plan_title.text = values.mealPlanName
            adapter = MealPlanRecipeAdapter(context,values.meals)
            lv_recipes.adapter = adapter
        })
    }

}
