package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryMeals
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.CuisineTicketBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.RecipeActivity

class CuisineAdapter : BaseAdapter {

    var context: Context? = null
    var listOfMeals = ArrayList<CategoryMeals>()

    constructor(context: Context?, listOfMeals: ArrayList<CategoryMeals>){
        this.context = context
        this.listOfMeals = listOfMeals
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val cuisine = listOfMeals[p0]
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding : CuisineTicketBinding = DataBindingUtil.inflate(inflator, R.layout.cuisine_ticket,null,false)

        binding.cuisine = cuisine

        binding.root.setOnClickListener {
            val intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("idMeal",binding.cuisine?.idMeal)
            context?.startActivity(intent)
        }

        return binding.root
    }

    override fun getItem(p0: Int): Any {
        return listOfMeals[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listOfMeals.size
    }
}