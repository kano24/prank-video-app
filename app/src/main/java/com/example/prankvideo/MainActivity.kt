package com.example.prankvideo

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )

        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.prank_video}")
        videoView.setVideoURI(videoUri)

        videoView.setOnPreparedListener { mp ->
            mp.isLooping = false
            videoView.start()
        }

        videoView.setOnCompletionListener {
            finish()
        }
    }
}
