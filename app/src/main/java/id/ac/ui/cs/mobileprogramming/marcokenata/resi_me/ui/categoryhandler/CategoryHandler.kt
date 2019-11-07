package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.categoryhandler

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import dagger.android.support.AndroidSupportInjection

import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.CuisineAdapter
import kotlinx.android.synthetic.main.category_handler_fragment.*
import javax.inject.Inject

class CategoryHandler : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: CategoryHandlerViewModelFactory

    private lateinit var viewModel: CategoryHandlerViewModel

    var adapter : CuisineAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.category_handler_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CategoryHandlerViewModel::class.java)
        val intent = activity?.intent?.extras
        val category = intent?.get("strCategory").toString()
        viewModel.getCategory(category)

        viewModel.categoryLiveData.observe(this, Observer { value ->
            tv_hello.text = category
            adapter = CuisineAdapter(context,value.meals)
            lv_cuisines.adapter = adapter
        })


    }

}
