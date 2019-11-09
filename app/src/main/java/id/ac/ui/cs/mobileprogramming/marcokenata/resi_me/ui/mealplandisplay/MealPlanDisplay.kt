package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplandisplay

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.MealPlanRecipeAdapter
import kotlinx.android.synthetic.main.meal_plan_display_fragment.*
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.NotificationService
import java.text.SimpleDateFormat
import java.util.*
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

        val myCalendar = Calendar.getInstance()


        val date = DatePickerDialog.OnDateSetListener { view, year, month, dateOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dateOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            et_date.text = sdf.format(myCalendar.time)
        }

        et_date.setOnClickListener {
            DatePickerDialog(
                context!!,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        val time = TimePickerDialog.OnTimeSetListener {view, hour, minute ->
            myCalendar.set(Calendar.HOUR_OF_DAY, hour)
            myCalendar.set(Calendar.MINUTE, minute)
            myCalendar.set(Calendar.SECOND,0)
            editText2.text = ""+hour+":"+minute
        }

        editText2.setOnClickListener {
            TimePickerDialog(
                context!!,time,myCalendar.get(Calendar.HOUR_OF_DAY),myCalendar.get(Calendar.MINUTE),true
            ).show()
        }

        bt_reminder.setOnClickListener {
            val intentReminder = Intent(context,NotificationService::class.java)
            intentReminder.putExtra("calendar",myCalendar)
            Toast.makeText(context,R.string.reminder_is_set,Toast.LENGTH_SHORT).show()
            activity?.startService(intentReminder)
        }


        viewModel.getPlan(idMeal)

        viewModel.mealPlanLiveData.observe(this, Observer { values ->
            tv_meal_plan_title.text = values.mealPlanName
            adapter = MealPlanRecipeAdapter(context,values.meals)
            lv_recipes.adapter = adapter
        })


    }

}
