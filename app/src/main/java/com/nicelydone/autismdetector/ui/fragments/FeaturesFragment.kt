package com.nicelydone.autismdetector.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.FragmentFeaturesBinding
import com.nicelydone.autismdetector.models.FeaturesData
import com.nicelydone.autismdetector.models.Items
import com.nicelydone.autismdetector.ui.fragments.adapter.AboutAdapter
import com.nicelydone.autismdetector.ui.fragments.adapter.FeatureAdapter

class FeaturesFragment : Fragment() {

   private lateinit var binding: FragmentFeaturesBinding
   private val list = ArrayList<FeaturesData>()

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_features, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding = FragmentFeaturesBinding.bind(view)

      list.addAll(getListData())
      binding.rvFeatures.layoutManager = LinearLayoutManager(context)

      binding.rvFeatures.setHasFixedSize(true)
      val featuresAdapter = FeatureAdapter(list)
      val featuresDecoration = DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
      binding.rvFeatures.addItemDecoration(featuresDecoration)
      binding.rvFeatures.adapter = featuresAdapter

   }
   private fun getListData(): ArrayList<FeaturesData>{
      val dataName = resources.getStringArray(R.array.feature_name)
      val dataDesc = resources.getStringArray(R.array.feature_description)
      val dataCat = resources.getStringArray(R.array.features_category)
      val dataLists = ArrayList<FeaturesData>()

      for (item in dataName.indices) {
         val items = FeaturesData(featureName = dataName[item], featureDescription = dataDesc[item], featureType = dataCat[item])
         dataLists.add(items)
      }
      return dataLists
   }
}