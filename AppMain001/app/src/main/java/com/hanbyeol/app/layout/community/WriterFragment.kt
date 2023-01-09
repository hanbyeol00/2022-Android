package com.hanbyeol.app.layout.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.snackbar.Snackbar
import com.hanbyeol.app.MainActivity
import com.hanbyeol.app.R
import com.hanbyeol.app.databinding.FragmentWriterBinding

class WriterFragment : Fragment() {

    private lateinit var binding : FragmentWriterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCommunityFree.setOnClickListener {
            if (binding.btnCommunityFree.isChecked) {
                Log.d("눌림", "123")
            }
        }
    }
}