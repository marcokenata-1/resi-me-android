package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.RecipeTicketBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.RecipeActivity

class RecipeAdapter : BaseAdapter {

    var context: Context? = null
    private var savedRecipesList = ArrayList<SavedRecipes>()

    constructor(context: Context?, savedRecipesList: List<SavedRecipes>){
        this.context = context
        this.savedRecipesList = savedRecipesList as ArrayList<SavedRecipes>
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val recipe = savedRecipesList[p0]
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bindingTicket : RecipeTicketBinding = DataBindingUtil.inflate(inflator, R.layout.recipe_ticket,null,false)

        bindingTicket.recipe = recipe.meals

        if (recipe.equals(null)){

        }

        bindingTicket.root.setOnClickListener{
            val intent = Intent(context, RecipeActivity::class.java)
            intent.putExtra("idMeal",bindingTicket.recipe?.idMeal)
            context?.startActivity(intent)
        }

        return bindingTicket.root
    }

    override fun getItem(p0: Int): Any {
        return savedRecipesList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return savedRecipesList.size
    }
}