package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.cookingsteps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.CookingStepFragmentBinding
import kotlinx.android.synthetic.main.cooking_step_fragment.*
import javax.inject.Inject

class CookingStep : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: CookingStepViewModelFactory

    private lateinit var viewModel: CookingStepViewModel

    private lateinit var binding: CookingStepFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.cooking_step_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CookingStepViewModel::class.java)
        val intent = activity?.intent?.extras
        val idMeal = intent?.get("idMeal").toString().toInt()
        viewModel.getId(idMeal)

        viewModel.recipeLiveData.observe(this, Observer { value ->
            binding.recipe = value
            tv_done.setOnClickListener{
                val action = CookingStepDirections.actionCookingStepToCongratulations()
                view?.findNavController()?.navigate(action)
            }
        })

    }

}
