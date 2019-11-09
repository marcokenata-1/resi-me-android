package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.HomeFragmentBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.RecipeActivity
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.CategoryAdapter
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.BuildConfig
import kotlinx.android.synthetic.main.home_fragment.*
import java.io.*
import javax.inject.Inject




class Home : Fragment() {

    @Inject
    internal lateinit var viewModelFactory: HomeViewModelFactory

    private lateinit var viewModel: HomeViewModel

    lateinit var binding: HomeFragmentBinding

    var adapter : CategoryAdapter? = null

    private val ASSET_NAME = "Frequently Asked Questions.pdf"
    private var cacheFile: File? = null

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

        tv_faq.setOnClickListener {
            if (cacheFileDoesNotExist()) {
                createCacheFile()
            }
            val uri = activity?.packageName?.let { it1 ->
                FileProvider.getUriForFile(this.context!!,
                    it1, cacheFile!!)
            }
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = uri
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context?.startActivity(intent)
        }

    }

    private fun cacheFileDoesNotExist(): Boolean {
        if (cacheFile == null) {
            cacheFile = File(activity?.cacheDir, ASSET_NAME)
        }
        return !cacheFile!!.exists()
    }

    private fun createCacheFile(){
        var inputStream:InputStream? = null
        var outputStream:OutputStream? = null
        try
        {
            inputStream = activity?.assets?.open(ASSET_NAME)
            outputStream = FileOutputStream(cacheFile)
            inputStream?.copyTo(outputStream)
        }
        catch (e:IOException) {
            e.printStackTrace()
        }
        finally
        {
            close(inputStream)
            close(outputStream)
        }
    }

    private fun close(closeable: Closeable?) {
        if (closeable == null) {
            return
        }
        try {
            closeable.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }



}
