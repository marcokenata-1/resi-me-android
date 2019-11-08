package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.congratulations

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.CongratulationsFragmentBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity
import kotlinx.android.synthetic.main.congratulations_fragment.*
import javax.inject.Inject

class Congratulations : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: CongratulationsViewModelFactory

    private lateinit var viewModel: CongratulationsViewModel

    private lateinit var binding: CongratulationsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.congratulations_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CongratulationsViewModel::class.java)
        val intent = activity?.intent?.extras
        val idMeal = intent?.get("idMeal").toString().toInt()
        viewModel.getId(idMeal)
        viewModel.recipeLiveData.observe(this, Observer { value ->
            binding.recipe = value
            tv_back.setOnClickListener{
                val intent1 = Intent(context,MainActivity::class.java)
                context?.startActivity(intent1)
            }
            tv_save.setOnClickListener {
                if (viewModel.saved.equals("tidak")){
                    viewModel.saveRecipe(idMeal)
                    Toast.makeText(context, "Recipe Saved", Toast.LENGTH_SHORT).show()
                    tv_save.visibility = View.GONE
                } else {
                    Toast.makeText(context, "You have already saved this recipe", Toast.LENGTH_SHORT).show()
                    tv_save.visibility = View.GONE
                }
            }
        })
    }

}
