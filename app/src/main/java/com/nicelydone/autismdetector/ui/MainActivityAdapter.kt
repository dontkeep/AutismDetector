package com.nicelydone.autismdetector.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nicelydone.autismdetector.ui.fragments.AboutAppFragment
import com.nicelydone.autismdetector.ui.fragments.DatasetsFragment
import com.nicelydone.autismdetector.ui.fragments.FeaturesFragment
import com.nicelydone.autismdetector.ui.fragments.ModelFragment
import com.nicelydone.autismdetector.ui.fragments.ProfileFragment

class MainActivityAdapter(activityAdapter: AppCompatActivity): FragmentStateAdapter(activityAdapter) {
   override fun getItemCount(): Int {
      return 5
   }

   override fun createFragment(position: Int): Fragment {
      val fragment1 = AboutAppFragment()
      val fragment2 = DatasetsFragment()
      val fragment3 = FeaturesFragment()
      val fragment4 = ModelFragment()
      val fragment5 = ProfileFragment()

      when (position) {
         0 -> return fragment1
         1 -> return fragment2
         2 -> return fragment3
         3 -> return fragment4
         4 -> return fragment5
      }
      return fragment1
   }
}