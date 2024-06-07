package com.nicelydone.autismdetector.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.tensorflow.lite.Interpreter


class MainViewModel: ViewModel() {
   private val _result = MutableLiveData<Float>()
   private val _loading = MutableLiveData<Boolean>()

   val result: LiveData<Float> = _result
   val loading: LiveData<Boolean> = _loading

   init {
      _loading.value = false
   }
   fun doInference(finalArray: Array<String>, interpreter: Interpreter) {
      _loading.value = true
      val input = FloatArray(18)
      if (!finalArray.contentEquals(Array(18){""})){
         for (i in 0..17) {
            input[i] = finalArray[i].toFloat()
         }
         val output = Array(1) { FloatArray(1) }
         interpreter.run(input, output)
         _result.value = output[0][0]
         _loading.value = false
      }
   }
}