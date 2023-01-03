package com.example.app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
        for (i in 1..line){
            val lineValue = arrayOf("    ㅣ","ㅡㅣ","    ㅣ","    ㅣ","    ㅣ","    ㅣ","    ㅣ")
            if(i === 1) {
                txtLine[i - 1].append(" ${i}\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\nㅣ\n")
            } else {
                txtLine[i - 1].append("    ${i}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n${lineValue.random()}\n")
            }
        }


        return root
    }
}