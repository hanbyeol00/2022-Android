package com.hanbyeol.app.layout.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanbyeol.app.MainActivity
import com.hanbyeol.app.adapter.CommunityRecyclerAdapter
import com.hanbyeol.app.databinding.FragmentCommunityBinding
import com.hanbyeol.app.layout.FRAGMENT_WRITER
import com.hanbyeol.app.models.CommunityViewModel

class CommunityFragment : Fragment() {

    private lateinit var binding : FragmentCommunityBinding
    private val communityViewModel : CommunityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val communityAdapter = CommunityRecyclerAdapter(communityViewModel.communityList)
        // binding.studentList.layoutManager = LinearLayoutManager(context)
        // binding.studentList.adapter = studentAdapter
        with(binding.communityList){
            layoutManager = LinearLayoutManager(context)
            adapter = communityAdapter
        }

        communityViewModel.communityList.observe(
            viewLifecycleOwner,
            Observer { communityAdapter.modifyNotice() }
        )
        val mainActivity = activity as MainActivity
        binding.btnWriter.setOnClickListener {
            mainActivity.changFragment(FRAGMENT_WRITER)
        }
    }
}