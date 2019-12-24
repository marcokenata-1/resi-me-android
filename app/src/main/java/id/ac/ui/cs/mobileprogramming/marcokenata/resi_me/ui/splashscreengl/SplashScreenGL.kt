package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.splashscreengl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.R
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity

class SplashScreenGL : AppCompatActivity() {
    val loading_time = 2000

    var openGLView: OpenGLView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_gl)

        supportActionBar?.hide()

        openGLView = findViewById(R.id.splash_screen)

        Handler().postDelayed(Runnable {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, loading_time.toLong())
    }

}
