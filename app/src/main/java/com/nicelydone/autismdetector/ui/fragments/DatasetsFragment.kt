package com.nicelydone.autismdetector.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicelydone.autismdetector.R
import com.nicelydone.autismdetector.databinding.FragmentDatasetsBinding
import com.nicelydone.autismdetector.models.DataItems
import com.nicelydone.autismdetector.ui.fragments.adapter.DatasetTableAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

class DatasetsFragment : Fragment() {

   private lateinit var binding: FragmentDatasetsBinding
   private var dataList = ArrayList<DataItems>()
   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_datasets, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      binding = FragmentDatasetsBinding.bind(view)
      getData()
      val rvDatasets = binding.rvData
      rvDatasets.layoutManager = LinearLayoutManager(requireContext())
      rvDatasets.adapter = DatasetTableAdapter(dataList)


   }
   fun getData(){
      lifecycleScope.launch {
         dataList = ArrayList<DataItems>().apply{
            add(
               DataItems("1","1","1","1","1","0","1","1","1","1","36.0","m","Others","yes","no","United States","no","9.0","18 and more","Self","YES"))
            add(
               DataItems("0","1","0","0","0","0","0","1","0","0","17.0","f","Black","no","no","United States","no","2.0","18 and more","Self","NO")
            )
            add(
               DataItems("1","1","1","1","0","0","0","0","1","0","64.0","m","White-European","no","no","New Zealand","no","5.0","18 and more","Parent","NO")
            )
            add(
               DataItems("1","1","0","0","1","0","0","1","1","1","29.0","m","White-European","no","no","United States","no","6.0","18 and more","Self","NO")
            )
            add(
               DataItems("1","1","1","1","0","1","1","1","1","0","17.0","m","Asian","yes","yes","Bahamas","no","8.0","18 and more","Health care professional","YES")
            )
            add(
               DataItems("1","1","1","1","1","1","1","1","1","1","33.0","m","White-European","no","no","United States","no","10.0","18 and more","Relative","YES")
            )
            add(
               DataItems("0","1","0","1","1","1","1","0","0","1","18.0","f","Middle Eastern","no","no","Burundi","no","6.0","18 and more","Parent","NO")
            )
            add(
               DataItems("0","1","1","1","1","1","0","0","1","0","17.0","f","?","no","no","Bahamas","no","6.0","18 and more","?","NO")
            )
            add(
               DataItems("1","0","0","0","0","0","1","1","0","1","17.0","m","?","no","no","Austria","no","4.0","18 and more","?","NO")
            )
            add(
               DataItems("1","0","0","0","0","0","1","1","0","1","17.0","f","?","no","no","Argentina","no","4.0","18 and more","?","NO")
            )
         }
      }
   }
}