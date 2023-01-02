package com.hanbyeol.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.hanbyeol.app.databinding.ActivityInputWordBinding

class InputWord : AppCompatActivity() {

    private lateinit var binding: ActivityInputWordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textWord.setOnEditorActionListener { view, keyCode, event ->
            val word = binding.textWord.text.toString()
            val message = "단어를입력해주세요"
            if (word.isEmpty()) {
                Snackbar
                    .make(
                        view,
                        message,
                        Snackbar.LENGTH_LONG
                    )
                    .show()
            }
            /**
             * input box 의 키보드가 보이는 상태에서
             * Snack bar 를 보이면 키보드에 가려서 Snack bar 가 보이지 않기 때문에
             * 마지막 값을 false 로 해주면 키보드가 자동으로 사라진다
             */
            false
        }
    }
}