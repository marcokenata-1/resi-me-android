package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Meals
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.SelectorTicketBinding
import kotlinx.android.synthetic.main.selector_ticket.view.*


class SelectorAdapter : RecyclerView.Adapter<SelectorAdapter.MultiViewHolder> {

    var context: Context? = null
    var listOfRecipes =  ArrayList<SavedRecipes>()
    var binding :SelectorTicketBinding? = null


    constructor(context: Context?, listOfRecipes: List<SavedRecipes>){
        this.context = context
        this.listOfRecipes = listOfRecipes as ArrayList<SavedRecipes>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiViewHolder {
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = DataBindingUtil.inflate(inflator, R.layout.selector_ticket,null,false)
        return MultiViewHolder(binding?.root)
    }

    override fun getItemCount(): Int {
        return listOfRecipes.size
    }

    override fun onBindViewHolder(holder: MultiViewHolder, position: Int) {
        binding?.recipe = listOfRecipes[position]
        holder.bind(listOfRecipes[position])
    }

    fun getAll() : ArrayList<Meals?>{
        val selected = ArrayList<Meals?>()
        for (i in listOfRecipes){
            if (i.isChecked){
                selected.add(i.meals)
            }
        }
        return selected
    }


    class MultiViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {

        fun bind(savedRecipes: SavedRecipes){
            if (savedRecipes.isChecked){
                itemView.iv_check.visibility = View.VISIBLE
            } else {
                itemView.iv_check.visibility = View.GONE
            }
            itemView.setOnClickListener {
                savedRecipes.isChecked = !savedRecipes.isChecked
                itemView.iv_check.visibility = if (savedRecipes.isChecked) View.VISIBLE else View.GONE
            }
        }
    }
}