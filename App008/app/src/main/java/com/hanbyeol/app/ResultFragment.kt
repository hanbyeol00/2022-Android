package com.hanbyeol.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hanbyeol.app.databinding.FragmentResultBinding


class ResultFragment : Fragment() {

    private var _binding : FragmentResultBinding ? = null
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

        _binding = FragmentResultBinding.inflate(inflater,container,false)

        val root:View = binding.root
        val txtResult = binding.txtResult
        val btnBack = binding.btnBack

        btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
        }

        val args : MainFragmentArgs by navArgs()

        txtResult.text = args.word


        return root


        // Inflate the layout for this fragment

    }
}