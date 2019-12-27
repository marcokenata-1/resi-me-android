package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.BroadcastService
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.databinding.HomeFragmentBinding
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.RecipeActivity
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.adapters.CategoryAdapter
import kotlinx.android.synthetic.main.home_fragment.*
import java.io.*
import java.lang.Exception
import javax.inject.Inject
import kotlin.math.min


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

        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkInfo = connectivityManager.activeNetworkInfo


        if (networkInfo != null && networkInfo.isConnected) {
            viewModel.getRandom.observe(this, Observer { value ->
                binding.random = value.meals[0]
                iv_card_view.setOnClickListener {
                    val intent = Intent(context, RecipeActivity::class.java)
                    intent.putExtra("idMeal", value.meals[0].idMeal)
                    context?.startActivity(intent)
                }
            })

            viewModel.getCategory.observe(this, Observer { value ->
                adapter = CategoryAdapter(context, value.categories)
                gv_categories.adapter = adapter
            })

            tv_faq.setOnClickListener {
                if (cacheFileDoesNotExist()) {
                    createCacheFile()
                }
                val uri = activity?.packageName?.let { it1 ->
                    FileProvider.getUriForFile(
                        this.context!!,
                        it1, cacheFile!!
                    )
                }
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                context?.startActivity(intent)
            }

        } else {
            //munculkan kata no connectivity
            tv_faq.visibility = View.GONE
            tv_no_connection.visibility = View.VISIBLE
            tv_top_recipes.visibility = View.GONE
            tv_popular_recipes.visibility = View.GONE
        }

        bt_timer_start.setOnClickListener {
            if((et_minutes.text.toString().toLong() > 60 && et_seconds.text.toString().toLong() > 60)  || et_seconds.text.equals(null)){
                Toast.makeText(context,"Please fill the minutes and the seconds of the timer",Toast.LENGTH_SHORT).show()
            } else {

                var minutes = et_minutes.text.toString().toLong()
                val seconds = et_seconds.text.toString().toLong()

                if (et_minutes.text.equals(null)){
                    minutes = 0
                }

                val kombinasi = ((minutes * 60 ) + seconds) * 1000
                val intent = Intent(context,BroadcastService::class.java)
                intent.putExtra("milli",kombinasi)
                activity?.startService(intent)
                Toast.makeText(context,"Timer started",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        activity?.registerReceiver(countdown_br, IntentFilter(BroadcastService.COUNTDOWN_BR))
    }

    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(countdown_br)
    }

    override fun onStop() {
        try {
            activity?.unregisterReceiver(countdown_br)
        } catch (e: Exception){

        }
        super.onStop()
    }

    override fun onDestroy() {
        activity?.stopService(Intent(context,BroadcastService::class.java))
        super.onDestroy()

    }

    private val countdown_br = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            if (p1 != null) {
                updateGUI(intent = p1)
            }
        }
    }

    fun updateGUI(intent: Intent){
        val seconds = intent.getLongExtra("countdown",10000) / 1000
        var minutes: Long = 0
        if (seconds > 60){
            minutes = seconds % 60
        }
        et_minutes.setText(minutes.toString())
        et_seconds.setText(seconds.toString())
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
