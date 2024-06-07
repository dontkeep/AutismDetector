package com.nicelydone.autismdetector.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.ItemCardBinding
import com.nicelydone.autismdetector.models.Items

class AboutAdapter(private val listItems: ArrayList<Items>): RecyclerView.Adapter<AboutAdapter.ViewHolder>() {

   class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      val title: TextView = itemView.findViewById(R.id.text_title)
      val content: TextView = itemView.findViewById(R.id.text_content)
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
      return ViewHolder(view)
   }

   override fun getItemCount(): Int {
      return listItems.size
   }

   override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val (title, content) = listItems[position]
      holder.content.text = content
      holder.title.text = title
   }
}