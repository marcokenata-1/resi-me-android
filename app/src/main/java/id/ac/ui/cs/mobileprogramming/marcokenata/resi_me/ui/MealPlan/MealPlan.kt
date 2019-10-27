package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MealPlan

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R

class MealPlan : Fragment() {

    companion object {
        fun newInstance() = MealPlan()
    }

    private lateinit var viewModel: MealPlanViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.meal_plan_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MealPlanViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
