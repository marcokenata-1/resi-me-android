package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import dagger.android.AndroidInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    var pressed:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        supportActionBar?.hide()

        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

        bottom_nav.setupWithNavController(navController)

        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onBackPressed() {
        if (pressed){
            finish()
        } else {
            Toast.makeText(this,"Tekan sekali lagi untuk keluar",Toast.LENGTH_SHORT).show()
            pressed = true
        }
    }


}
