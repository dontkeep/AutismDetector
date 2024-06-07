package com.nicelydone.autismdetector.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.models.FeaturesData

class FeatureAdapter(private val listData: ArrayList<FeaturesData>): RecyclerView.Adapter<FeatureAdapter.ViewHolder>() {
   class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      val featureName: TextView = itemView.findViewById(R.id.feature_name)
      val featureDesc: TextView = itemView.findViewById(R.id.feature_detail)
      val featureType: TextView = itemView.findViewById(R.id.feature_type)
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view: View = LayoutInflater.from(parent.context).inflate(R.layout.feature_item, parent, false)
      return ViewHolder(view)
   }

   override fun getItemCount(): Int {
      return listData.size
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val (featureName, featureType, featureDescription) = listData[position]
      holder.featureName.text = featureName
      holder.featureDesc.text = featureDescription
      holder.featureType.text = featureType
   }
}