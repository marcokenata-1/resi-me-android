package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MealPlan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import javax.inject.Inject

class MealPlan : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: MealPlanViewModelFactory

    private lateinit var viewModel: MealPlanViewModel

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
        // TODO: Use the ViewModel
    }

}
