package com.nicelydone.autismdetector.ui

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nicelydone.autismdetector.databinding.ActivityMainBinding
import com.nicelydone.autismdetector.viewmodel.MainViewModel
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
   var finalArray = Array(18){""}

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityMainBinding.inflate(layoutInflater)
      setContentView(binding.root)
      val viewMainModel = ViewModelProvider(this).get(MainViewModel::class.java)

      val bundle = intent.extras
      if (bundle != null) {
         finalArray = bundle.getStringArray("finalArray") as Array<String>
      }

      viewMainModel.loading.observe(this){
         if (it){
            binding.progressBar.visibility = View.VISIBLE
         }else{
            binding.progressBar.visibility = View.GONE
         }
      }

      val viewPager: ViewPager2 = binding.viewPager
      val sectionPagerAdapter = MainActivityAdapter(this)
      viewPager.isUserInputEnabled = false
      viewPager.adapter = sectionPagerAdapter
      val tabs: TabLayout = binding.tabLayout
      TabLayoutMediator(tabs, viewPager) { tab, position ->
         tab.text = when (position) {
            0 -> "Home"
            1 -> "Datasets"
            2 -> "Features"
            3 -> "Model"
            4 -> "About Me"
            else -> ""
         }
      }.attach()
   }
}