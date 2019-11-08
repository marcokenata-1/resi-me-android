package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R

class AdderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adder)

        AndroidInjection.inject(this)

        supportActionBar?.hide()
    }
}
