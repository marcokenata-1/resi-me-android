package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import kotlinx.android.synthetic.main.content_recipe.*

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_recipe)

//        AndroidInjection.inject(this)

        supportActionBar?.hide()

    }

}
