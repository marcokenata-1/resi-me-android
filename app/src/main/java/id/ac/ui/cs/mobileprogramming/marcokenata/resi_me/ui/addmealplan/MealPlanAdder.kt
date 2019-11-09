package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.addmealplan

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.AndroidSupportInjection

import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.SelectorAdapter
import kotlinx.android.synthetic.main.meal_plan_adder_fragment.*
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity
import javax.inject.Inject

class MealPlanAdder : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: MealPlanAdderViewModelFactory

    private lateinit var viewModel: MealPlanAdderViewModel


    var adapter: SelectorAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.meal_plan_adder_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MealPlanAdderViewModel::class.java)

        viewModel.savedRecipes.observe(this, Observer {
            adapter = SelectorAdapter(context,it)
            rv_selector.layoutManager = LinearLayoutManager(context)
            rv_selector.adapter = adapter
        })

        bt_add_meal.setOnClickListener {
            viewModel.addMeal(MealPlans(et_name.text.toString(),adapter!!.getAll()))
            val intentMain = Intent(context,MainActivity::class.java)
            Toast.makeText(context,R.string.meal_plan_added, Toast.LENGTH_SHORT).show()
            context?.startActivity(intentMain)
        }

    }

}
