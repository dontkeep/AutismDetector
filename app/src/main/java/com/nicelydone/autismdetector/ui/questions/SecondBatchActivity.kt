package com.nicelydone.autismdetector.ui.questions

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.ActivitySecondBatchBinding
import com.nicelydone.autismdetector.ui.MainActivity

class SecondBatchActivity : AppCompatActivity() {

   private lateinit var binding: ActivitySecondBatchBinding
   var finalResult: Int = 0
   val finalArray = Array(18){""}

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivitySecondBatchBinding.inflate(layoutInflater)
      setContentView(binding.root)
      val bundle = intent.extras
      val selectedItems = bundle!!.getStringArray("selectedItems")

      convertStringToInt(selectedItems)

      val adapterYesNo = ArrayAdapter(this,
         R.layout.list_items, resources.getStringArray(R.array.yesno))
      val adapterGender = ArrayAdapter(this,
         R.layout.list_items, resources.getStringArray(R.array.gender))
      val adapterEthnicity = ArrayAdapter(this,
         R.layout.list_items, resources.getStringArray(R.array.ethnicity))
      val adapterRelation = ArrayAdapter(this,
         R.layout.list_items, resources.getStringArray(R.array.relationship))
      autoCompleteAdapter(adapterYesNo, adapterGender, adapterEthnicity, adapterRelation)

      setupAutoCompleteListener2(binding.autoComplete12, 11)
      setupAutoCompleteListener2(binding.autoComplete13, 12)
      setupAutoCompleteListener2(binding.autoComplete14, 13)
      setupAutoCompleteListener2(binding.autoComplete15, 14)
      setupAutoCompleteListener2(binding.autoComplete16, 15)
      setupAutoCompleteListener2(binding.autoComplete17, 17)

      finalArray[16] = finalResult.toString()
      binding.question11.editText?.doOnTextChanged { inputText, _, _, _ ->
         finalArray[10] = inputText.toString()
      }

      binding.btnPredict.setOnClickListener {
         if(finalArray[10] == "" || finalArray[11] == "" || finalArray[12] == "" || finalArray[13] == "" || finalArray[14] == "" || finalArray[15] == "" || finalArray[16] == "" || finalArray[17] == ""){
            Toast.makeText(this, "Please Make Sure To Fill All Questions", Toast.LENGTH_SHORT).show()
         }else{
            convertStringToIntFinal(finalArray)
            val bundle = Bundle()
            val intent = Intent(this, MainActivity::class.java)
            bundle.putStringArray("finalArray", finalArray)
            intent.putExtras(bundle)
            startActivity(intent)
         }
      }
   }

   private fun setupAutoCompleteListener2(autoComplete: AutoCompleteTextView, index: Int) {
      val adapter = autoComplete.adapter ?: return  // Handle null adapter case

      autoComplete.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
         finalArray[index] = adapter.getItem(position).toString()
      }
   }

   private fun convertStringToIntFinal(finalArray: Array<String>) {
      for (i in finalArray.indices) {
         if(i == 13 || i == 14 || i == 15){
            if(finalArray[i] == "Yes"){
               finalArray[i] = "1"
            }
            if(finalArray[i] == "No"){
               finalArray[i] = "0"
            }
         }
         if(i == 11){
            if(finalArray[i] == "Male"){
               finalArray[i] = "1"
            }
            if(finalArray[i] == "Female"){
               finalArray[i] = "0"
            }
         }
         if(i == 17){
            if(finalArray[i] == "Self"){
               finalArray[i] = "4"
            }else if(finalArray[i] == "Parent"){
               finalArray[i] = "2"
            }else if(finalArray[i] == "Healthcare Professional"){
               finalArray[i] = "0"
            }else if(finalArray[i] == "Others"){
               finalArray[i] = "1"
            }else if(finalArray[i] == "Relative"){
               finalArray[i] = "3"
            }
         }
         if(i == 12){
            when(finalArray[i]){
               "White-European" -> finalArray[i] = "9"
               "Asian" -> finalArray[i] = "0"
               "Black" -> finalArray[i] = "1"
               "Hispanic" -> finalArray[i] = "2"
               "Latino" -> finalArray[i] = "3"
               "Middle Eastern" -> finalArray[i] = "4"
               "Pasifika" -> finalArray[i] = "6"
               "South Asian" -> finalArray[i] = "7"
               "Turkish" -> finalArray[i] = "8"
               else -> finalArray[i] = "10"
            }
         }
      }
   }

   private fun convertStringToInt(selectedItems: Array<String>?) {
      if (selectedItems != null) {
         for (i in selectedItems.indices) {
            if(i == 0 || i == 6 || i == 7 || i == 9){
               if(selectedItems[i] == "Definitely Agree" || selectedItems[i] == "Slightly Agree"){
                  finalArray[i] = "1"
                  finalResult += 1
               }else{
                  finalArray[i] = "0"
               }
            }else{
               if(selectedItems[i] == "Definitely Disagree" || selectedItems[i] == "Slightly Disagree"){
                  finalArray[i] = "1"
                  finalResult += 1
               }else{
                  finalArray[i] = "0"
               }
            }
         }
      }
   }

   private fun autoCompleteAdapter(adapterYesNo: ArrayAdapter<String>, adapterGender: ArrayAdapter<String>, adapterEthnicity: ArrayAdapter<String>, adapterRelation: ArrayAdapter<String>) {
      binding.autoComplete12.setAdapter(adapterGender)
      binding.autoComplete13.setAdapter(adapterEthnicity)
      binding.autoComplete14.setAdapter(adapterYesNo)
      binding.autoComplete15.setAdapter(adapterYesNo)
      binding.autoComplete16.setAdapter(adapterYesNo)
      binding.autoComplete17.setAdapter(adapterRelation)
   }

}