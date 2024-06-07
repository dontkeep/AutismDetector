package com.nicelydone.autismdetector.ui.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.FragmentAboutAppBinding
import com.nicelydone.autismdetector.models.Items
import com.nicelydone.autismdetector.ui.MainActivity
import com.nicelydone.autismdetector.ui.fragments.adapter.AboutAdapter
import com.nicelydone.autismdetector.ui.questions.FirstBatchActivity
import com.nicelydone.autismdetector.viewmodel.MainViewModel
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel

class AboutAppFragment : Fragment() {

   private lateinit var binding: FragmentAboutAppBinding
   private lateinit var interpreter: Interpreter
   private val mPath = "autism.tflite"
   private val list = ArrayList<Items>()

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      return inflater.inflate(R.layout.fragment_about_app, container, false)
   }

   @SuppressLint("SetTextI18n")
   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding = FragmentAboutAppBinding.bind(view)
      val activity: MainActivity? = activity as MainActivity?
      initInterpreter()
      val finalArray = activity?.finalArray

      val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

      if (finalArray != null) {
         mainViewModel.doInference(finalArray, interpreter)
      }

      mainViewModel.result.observe(viewLifecycleOwner) {result ->

         if (result == 0.0F || result == null) {
            binding.testResult.text = "Please do your test First"
         }else{
            if (result > .5) {
               binding.testResult.text = "You might be an Autistic Patient"
            }else{
               binding.testResult.text = "You are not an Autistic Patient"
            }
         }
      }

      list.addAll(getListContents())
      binding.rvAboutAutism.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

      binding.rvAboutAutism.setHasFixedSize(true)
      val aboutAdapter = AboutAdapter(list)
      binding.rvAboutAutism.adapter = aboutAdapter

      binding.questionButton.setOnClickListener {
         val intent = Intent(activity, FirstBatchActivity::class.java)
         startActivity(intent)
      }
   }
   //external functions
   fun initInterpreter() {
      val options = Interpreter.Options()
      options.setNumThreads(4)
      options.setUseNNAPI(true)
      interpreter = Interpreter(loadModelFile(context?.assets!!, mPath), options)
   }

   private fun loadModelFile(assets: AssetManager, mModelPath: String): MappedByteBuffer {
      val fileDescriptor = assets.openFd(mModelPath)
      val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
      val fileChannel = inputStream.channel
      val startOffset = fileDescriptor.startOffset
      val declaredLength = fileDescriptor.declaredLength
      return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
   }

   private fun getListContents(): ArrayList<Items> {
      val dataTitle = resources.getStringArray(R.array.about_titles)
      val dataContent = resources.getStringArray(R.array.about_contents)
      val listItems = ArrayList<Items>()

      for (item in dataTitle.indices) {
         val items = Items(title = dataTitle[item], content = dataContent[item])
         listItems.add(items)
      }
      return listItems
   }
}