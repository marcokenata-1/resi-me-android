package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategorySubs
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.CategoryTicketBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.CategoryActivity

class CategoryAdapter : BaseAdapter {

    var context: Context? = null
    var listOfCategory = ArrayList<CategorySubs>()

    constructor(context: Context?,listOfCategory : ArrayList<CategorySubs>){
        this.context = context
        this.listOfCategory = listOfCategory
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val category = listOfCategory[p0]
        val inflator = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val bindingTicket : CategoryTicketBinding = DataBindingUtil.inflate(inflator, R.layout.category_ticket,null,false)

        bindingTicket.category = category

        bindingTicket.root.setOnClickListener {
            val intent = Intent(context,CategoryActivity::class.java)
            intent.putExtra("strCategory",category.strCategory)
            context?.startActivity(intent)
        }

        return bindingTicket.root
    }

    override fun getItem(p0: Int): Any {
        return listOfCategory[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return listOfCategory.size
    }
}