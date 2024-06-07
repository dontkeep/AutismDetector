package com.nicelydone.autismdetector.ui.questions

import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.ActivityFirstBatchBinding
import com.nicelydone.autismdetector.databinding.ActivityMainBinding
import com.nicelydone.autismdetector.viewmodel.MainViewModel
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class FirstBatchActivity : AppCompatActivity() {

   private lateinit var binding: ActivityFirstBatchBinding
   val selectedItems = Array(10){""}

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      binding = ActivityFirstBatchBinding.inflate(layoutInflater)
      setContentView(binding.root)
      val items = listOf("Definitely Agree", "Slightly Agree", "Slightly Disagree", "Definitely Disagree")

      val adapter = ArrayAdapter(this, R.layout.list_items, items)

      //create a function to declare the adapter for each auto complete
      autoCompleteAdapter(adapter)

      setupAutoCompleteListener(binding.autoComplete1, 0)
      setupAutoCompleteListener(binding.autoComplete2, 1)
      setupAutoCompleteListener(binding.autoComplete3, 2)
      setupAutoCompleteListener(binding.autoComplete4, 3)
      setupAutoCompleteListener(binding.autoComplete5, 4)
      setupAutoCompleteListener(binding.autoComplete6, 5)
      setupAutoCompleteListener(binding.autoComplete7, 6)
      setupAutoCompleteListener(binding.autoComplete8, 7)
      setupAutoCompleteListener(binding.autoComplete9, 8)
      setupAutoCompleteListener(binding.autoComplete10, 9)

      binding.btnNext.setOnClickListener {
         //check if all items are selected
         if (selectedItems.all { it.isNotEmpty() }) {
            val intent = Intent(this, SecondBatchActivity::class.java)
            val bundle = Bundle()
            bundle.putStringArray("selectedItems", selectedItems)
            intent.putExtras(bundle)
            startActivity(intent)
         } else {
            Toast.makeText(this, "Please Make Sure To Fill All Questions", Toast.LENGTH_SHORT).show()
         }
      }
   }


   fun setupAutoCompleteListener(autoComplete: AutoCompleteTextView, index: Int) {
      val adapter = autoComplete.adapter ?: return  // Handle null adapter case

      autoComplete.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
         selectedItems[index] = adapter.getItem(position).toString()
      }
   }

   private fun autoCompleteAdapter(adapter: ArrayAdapter<String>) {
      binding.autoComplete1.setAdapter(adapter)
      binding.autoComplete2.setAdapter(adapter)
      binding.autoComplete3.setAdapter(adapter)
      binding.autoComplete4.setAdapter(adapter)
      binding.autoComplete5.setAdapter(adapter)
      binding.autoComplete6.setAdapter(adapter)
      binding.autoComplete7.setAdapter(adapter)
      binding.autoComplete8.setAdapter(adapter)
      binding.autoComplete9.setAdapter(adapter)
      binding.autoComplete10.setAdapter(adapter)
   }
}