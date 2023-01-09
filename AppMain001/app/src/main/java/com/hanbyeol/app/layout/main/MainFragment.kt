package com.hanbyeol.app.layout.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.hanbyeol.app.MainActivity
import com.hanbyeol.app.databinding.FragmentMainBinding
import com.hanbyeol.app.layout.FRAGMENT_COMMUNITY
import com.hanbyeol.app.models.CommunityViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val communityViewModel : CommunityViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        binding.btnCommunity.setOnClickListener {
            mainActivity.changFragment(FRAGMENT_COMMUNITY)
        }
    }
}


