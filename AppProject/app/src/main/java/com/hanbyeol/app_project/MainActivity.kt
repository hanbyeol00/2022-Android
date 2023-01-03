package com.hanbyeol.app_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.hanbyeol.app_project.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var line = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val btnPlus = binding.btnPlus
        val btnMinus = binding.btnMinus
        val BtnStart = binding.btnStart

        btnPlus.setOnClickListener {
            if(line < 6){
                line++
                BtnStart.text=getString(R.string.line, line)
            }else{
                Snackbar.make(it,"6이 최대값 입니다",Snackbar.LENGTH_LONG).show()
            }
        }
        btnMinus.setOnClickListener {
            if(line > 2){
                line--
                BtnStart.text=getString(R.string.line, line)
            }else{
                Snackbar.make(it,"2가 최소값 입니다",Snackbar.LENGTH_LONG).show()
            }
        }



        BtnStart.text=getString(R.string.line, line)
    }
}