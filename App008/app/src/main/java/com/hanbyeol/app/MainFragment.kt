package com.hanbyeol.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hanbyeol.app.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding ? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMainBinding.inflate(inflater,container,false)

        val root:View = binding.root
        val btnClick = binding.btnClick


        btnClick.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToResultFragment()
            val word = binding.txtWord.text.toString()
            action.word = word
            findNavController().navigate(action)
        }

        return root

    }
}