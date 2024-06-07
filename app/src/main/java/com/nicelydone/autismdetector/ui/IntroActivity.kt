package com.nicelydone.autismdetector.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
   private lateinit var binding: ActivityIntroBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityIntroBinding.inflate(layoutInflater)
      setContentView(binding.root)

      binding.btnGoToApp.setOnClickListener {
         startActivity(Intent(this, MainActivity::class.java))
      }
   }
}