package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.addnewrecipes

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R

class RecipeAdder : Fragment() {

    companion object {
        fun newInstance() = RecipeAdder()
    }

    private lateinit var viewModel: RecipeAdderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipe_adder_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeAdderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
