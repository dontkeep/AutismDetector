package com.nicelydone.autismdetector.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.models.DataItems

class DatasetTableAdapter(private val dataList: List<DataItems>): RecyclerView.Adapter<DatasetTableAdapter.DatasetViewHolder>() {

   class DatasetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
      val txt_a1_score: TextView = itemView.findViewById(R.id.a1_score)
      val txt_a2_score: TextView = itemView.findViewById(R.id.a2_score)
      val txt_a3_score: TextView = itemView.findViewById(R.id.a3_score)
      val txt_a4_score: TextView = itemView.findViewById(R.id.a4_score)
      val txt_a5_score: TextView = itemView.findViewById(R.id.a5_score)
      val txt_a6_score: TextView = itemView.findViewById(R.id.a6_score)
      val txt_a7_score: TextView = itemView.findViewById(R.id.a7_score)
      val txt_a8_score: TextView = itemView.findViewById(R.id.a8_score)
      val txt_a9_score: TextView = itemView.findViewById(R.id.a9_score)
      val txt_a10_score: TextView = itemView.findViewById(R.id.a10_score)
      val txt_age: TextView = itemView.findViewById(R.id.age)
      val txt_gender: TextView = itemView.findViewById(R.id.gender)
      val txt_ethnicity: TextView = itemView.findViewById(R.id.ethnicity)
      val txt_jundice: TextView = itemView.findViewById(R.id.jundice)
      val txt_austim: TextView = itemView.findViewById(R.id.autism)
      val txt_contry_of_res: TextView = itemView.findViewById(R.id.country_of_res)
      val txt_used_app_before: TextView = itemView.findViewById(R.id.used_app_before)
      val txt_result: TextView = itemView.findViewById(R.id.result)
      val txt_age_desc: TextView = itemView.findViewById(R.id.age_desc)
      val txt_relation: TextView = itemView.findViewById(R.id.relation)
      val txt_class: TextView = itemView.findViewById(R.id.classASD)
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatasetViewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.table_list_item, parent, false)
      return DatasetViewHolder(view)
   }

   override fun getItemCount(): Int {
      return dataList.size + 1
   }

   override fun onBindViewHolder(holder: DatasetViewHolder, position: Int) {
      val rowPos = holder.position
      if (rowPos == 0) {
         holder.apply {
            setHeaderBg(txt_a1_score)
            setHeaderBg(txt_a2_score)
            setHeaderBg(txt_a3_score)
            setHeaderBg(txt_a4_score)
            setHeaderBg(txt_a5_score)
            setHeaderBg(txt_a6_score)
            setHeaderBg(txt_a7_score)
            setHeaderBg(txt_a8_score)
            setHeaderBg(txt_a9_score)
            setHeaderBg(txt_a10_score)
            setHeaderBg(txt_age)
            setHeaderBg(txt_gender)
            setHeaderBg(txt_ethnicity)
            setHeaderBg(txt_jundice)
            setHeaderBg(txt_austim)
            setHeaderBg(txt_contry_of_res)
            setHeaderBg(txt_used_app_before)
            setHeaderBg(txt_result)
            setHeaderBg(txt_age_desc)
            setHeaderBg(txt_relation)
            setHeaderBg(txt_class)

            txt_a1_score.text = "a1_score"
            txt_a2_score.text = "a2_score"
            txt_a3_score.text = "a3_score"
            txt_a4_score.text = "a4_score"
            txt_a5_score.text = "a5_score"
            txt_a6_score.text = "a6_score"
            txt_a7_score.text = "a7_score"
            txt_a8_score.text = "a8_score"
            txt_a9_score.text = "a9_score"
            txt_a10_score.text = "a10_score"
            txt_age.text = "age"
            txt_gender.text = "gender"
            txt_ethnicity.text = "ethnicity"
            txt_jundice.text = "jundice"
            txt_austim.text = "austim"
            txt_contry_of_res.text = "contry_of_res"
            txt_used_app_before.text = "used_app_before"
            txt_result.text = "result"
         }
      }else {
         val data = dataList[rowPos - 1]

         holder.apply {
            setContentBg(txt_a1_score)
            setContentBg(txt_a2_score)
            setContentBg(txt_a3_score)
            setContentBg(txt_a4_score)
            setContentBg(txt_a5_score)
            setContentBg(txt_a6_score)
            setContentBg(txt_a7_score)
            setContentBg(txt_a8_score)
            setContentBg(txt_a9_score)
            setContentBg(txt_a10_score)

            setContentBg(txt_age)
            setContentBg(txt_gender)
            setContentBg(txt_ethnicity)
            setContentBg(txt_jundice)
            setContentBg(txt_austim)
            setContentBg(txt_contry_of_res)
            setContentBg(txt_used_app_before)
            setContentBg(txt_result)
            setContentBg(txt_age_desc)
            setContentBg(txt_relation)
            setContentBg(txt_class)

            txt_a1_score.text = data.A1_Score
            txt_a2_score.text = data.A2_Score
            txt_a3_score.text = data.A3_Score
            txt_a4_score.text = data.A4_Score
            txt_a5_score.text = data.A5_Score
            txt_a6_score.text = data.A6_Score
            txt_a7_score.text = data.A7_Score
            txt_a8_score.text = data.A8_Score
            txt_a9_score.text = data.A9_Score
            txt_a10_score.text = data.A10_Score
            txt_age.text = data.age
            txt_gender.text = data.gender
            txt_ethnicity.text = data.ethnicity
            txt_jundice.text = data.jundice
            txt_austim.text = data.austim
            txt_contry_of_res.text = data.contry_of_res
            txt_used_app_before.text = data.used_app_before
            txt_result.text = data.result
            txt_age_desc.text = data.age_desc
            txt_relation.text = data.relation
            txt_class.text = data.ClassASD
         }
      }
   }

   private fun setHeaderBg(view: View) {
      view.setBackgroundResource(R.drawable.table_header_cell_bg)
   }

   private fun setContentBg(view: View) {
      view.setBackgroundResource(R.drawable.table_content_cell_bg)
   }
}