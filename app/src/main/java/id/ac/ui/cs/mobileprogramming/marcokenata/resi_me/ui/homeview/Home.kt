package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.HomeFragmentBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.CategoryAdapter
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.RecipeActivity
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class Home : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: HomeViewModelFactory

    private lateinit var viewModel: HomeViewModel

    lateinit var binding: HomeFragmentBinding

    var adapter : CategoryAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(HomeViewModel::class.java)

        viewModel.getRandom.observe(this, Observer { value ->
            binding.random = value.meals[0]
            iv_card_view.setOnClickListener{
                val intent = Intent(context, RecipeActivity::class.java)
                intent.putExtra("idMeal",value.meals[0].idMeal)
                context?.startActivity(intent)
            }
        })

        viewModel.getCategory.observe(this, Observer { value ->
            adapter = CategoryAdapter(context,value.categories)
            gv_categories.adapter = adapter
        })


    }



}
