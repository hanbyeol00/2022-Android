package com.hanbyeol.app_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.hanbyeol.app_project.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var line = 2

    private var _binding : FragmentMainBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container, false)

        val root:View = binding.root

        val btnPlus = binding.btnPlus
        val btnMinus = binding.btnMinus
        val BtnStart = binding.btnStart

        btnPlus.setOnClickListener {
            if(line < 6){
                line++
                BtnStart.text=getString(R.string.line, line)
            }else{
                Snackbar.make(it,"6이 최대값 입니다", Snackbar.LENGTH_LONG).show()
            }
        }
        btnMinus.setOnClickListener {
            if(line > 2){
                line--
                BtnStart.text=getString(R.string.line, line)
            }else{
                Snackbar.make(it,"2가 최소값 입니다", Snackbar.LENGTH_LONG).show()
            }
        }



        BtnStart.text=getString(R.string.line, line)

        return root
    }
}