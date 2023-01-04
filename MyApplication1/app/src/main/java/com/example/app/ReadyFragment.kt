package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.app.databinding.FragmentReadyBinding

class ReadyFragment : Fragment() {



    private var _binding : FragmentReadyBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentReadyBinding.inflate(inflater,container,false)

        var root:View = binding.root
        val txtLine = arrayOf(binding.txtLine1,binding.txtLine2,binding.txtLine3,binding.txtLine4,binding.txtLine5,binding.txtLine6)
        val args : MainFragmentArgs by navArgs()
        val line = args.line


        return root
    }
}