package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.MealPlanTicketBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MealPlanActivity

class MealPlanAdapter : BaseAdapter {

    var context: Context? = null
    private var savedMealPlanList = ArrayList<MealPlans>()

    constructor(context: Context?,savedMealPlanList : List<MealPlans>){
        this.context = context
        this.savedMealPlanList = savedMealPlanList as ArrayList<MealPlans>
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val mealPlans = savedMealPlanList[p0]
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bindingTicket : MealPlanTicketBinding = DataBindingUtil.inflate(inflator, R.layout.meal_plan_ticket,null,false)

        bindingTicket.mealplan = mealPlans

        if (mealPlans.equals(null)){

        }

        bindingTicket.root.setOnClickListener {
            val intentMealPlan = Intent(context,MealPlanActivity::class.java)
            intentMealPlan.putExtra("idMealPlan",bindingTicket.mealplan?.id)
            context?.startActivity(intentMealPlan)
        }

        return bindingTicket.root
    }

    override fun getItem(p0: Int): Any {
        return savedMealPlanList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return savedMealPlanList.size
    }
}