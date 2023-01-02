package com.hanbyeol.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val txtPlus = findViewById<TextView>(R.id.txt_plus)
        val txtMinus = findViewById<TextView>(R.id.txt_minus)
        val txtMultiplication = findViewById<TextView>(R.id.txt_multiplication)
        val txtDivision = findViewById<TextView>(R.id.txt_division)

        val intAdd1 = intent.getIntExtra("add1",0)
        val intAdd2 = intent.getIntExtra("add2",0)

        txtPlus.text = "$intAdd1 + $intAdd2 = ${intAdd1+intAdd2}"
        txtMinus.text = "$intAdd1 - $intAdd2 = ${intAdd1-intAdd2}"
        txtMultiplication.text = "$intAdd1 x $intAdd2 = ${intAdd1*intAdd2}"
        txtDivision.text = "$intAdd1 ÷ $intAdd2 = ${intAdd1/intAdd2}"

    }
}