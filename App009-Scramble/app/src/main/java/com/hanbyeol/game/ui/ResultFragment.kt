package com.hanbyeol.game.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.hanbyeol.game.MainActivity
import com.hanbyeol.game.databinding.FragmentResultBinding
import com.hanbyeol.game.models.WordViewModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val wordViewModel: WordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    } // end CreateView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.wordViewModel = wordViewModel

        val inputText = wordViewModel.inputWord.value.toString()
        val unscrambleText = wordViewModel.unscrambleWord.value.toString()

        val oldScore = wordViewModel.gameScore.value!!.toInt()
        val oldCount = wordViewModel.gameCount.value!!.toInt()
        var newScore = 0
        // if 를 사용하여 단어 비교
        var resultMsg = "오답"
        if (inputText.equals(unscrambleText, true)) {
            // 점수 증가하기
            wordViewModel.gameScore.value = oldScore + 1
            newScore = oldScore + 1
            Log.d("현재점수", newScore.toString())
            // 카운트 증가

            if (newScore >= 10) {
                resultMsg = "정답입니다! 클리어 축하합니다!"
                Snackbar.make(view, "축하합니다", Snackbar.LENGTH_LONG).show()
            } else {
                resultMsg = "정답!"
            }
        }
        wordViewModel.gameCount.value = oldCount + 1
        wordViewModel.gameResult.value = resultMsg

        binding.btnReturn.setOnClickListener {
            if (newScore >= 10) {
                wordViewModel.inputWord.value = null
                wordViewModel.gameCount.value = 0
                wordViewModel.gameScore.value = 0
            } else {
                wordViewModel.inputWord.value = null
            }
            wordViewModel.nextWord()
            val mainActivity = activity as MainActivity
            mainActivity.changFragment(FRAGMENT_MAIN)
        }
    }
}