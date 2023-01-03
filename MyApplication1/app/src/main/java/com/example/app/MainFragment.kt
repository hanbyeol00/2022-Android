package com.example.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding ? = null
    private val binding get() = _binding!!
    private var line = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater,container,false)

        val root:View = binding.root
        val btnPlus = binding.btnPlus
        val btnMinus = binding.btnMinus
        val btnStart = binding.btnStart

        btnPlus.setOnClickListener {
            if(line < 6){
                line++
                btnStart.text = getString(R.string.line, line)
            }else{
                Snackbar.make(it,"6이 최대값 입니다",Snackbar.LENGTH_LONG).show()
            }
        }

        btnMinus.setOnClickListener {
            if(line > 2){
                line--
                btnStart.text = getString(R.string.line, line)
            }else{
                Snackbar.make(it,"2가 최소값 입니다",Snackbar.LENGTH_LONG).show()
            }
        }

        btnStart.text = getString(R.string.line, line)

        btnStart.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToReadyFragment()
            action.line = line
            findNavController().navigate(action)
        }

        return root
    }
}