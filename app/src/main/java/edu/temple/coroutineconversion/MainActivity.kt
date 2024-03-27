package edu.temple.coroutineconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    //TODO (Refactor to replace Thread code with coroutines)

    lateinit var cakeImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cakeImageView = findViewById(R.id.imageView)

        findViewById<Button>(R.id.revealButton).setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                revealImage()
            }
        }
    }

    private suspend fun revealImage() {
        repeat(100) { i ->
            cakeImageView.alpha = i / 100f
            delay(40)
        }
    }
}