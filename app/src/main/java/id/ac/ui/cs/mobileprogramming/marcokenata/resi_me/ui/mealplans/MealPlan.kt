package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplans

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.AdderActivity
import androidx.navigation.findNavController
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.MealPlanAdapter
import kotlinx.android.synthetic.main.meal_plan_fragment.*
import javax.inject.Inject

class MealPlan : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: MealPlanViewModelFactory

    private lateinit var viewModel: MealPlanViewModel

    var adapter : MealPlanAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.meal_plan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MealPlanViewModel::class.java)

        viewModel.mealPlanLiveData.observe(this, Observer {lists ->
            adapter = lists?.let { MealPlanAdapter(context, it) }
            lv_meal_plan.adapter = adapter
        })

        bt_meal_plan.setOnClickListener {
            val intent = Intent(context,AdderActivity::class.java)
            context?.startActivity(intent)
        }


    }

}
