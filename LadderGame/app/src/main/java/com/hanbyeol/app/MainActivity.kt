package com.hanbyeol.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hanbyeol.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@MainActivity,LadderActivity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}