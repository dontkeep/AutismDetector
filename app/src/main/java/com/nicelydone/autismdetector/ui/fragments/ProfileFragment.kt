package com.nicelydone.autismdetector.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
   private lateinit var binding: FragmentProfileBinding

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_profile, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding = FragmentProfileBinding.bind(view)

   }
   companion object {

   }
}