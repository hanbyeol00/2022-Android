package com.hanbyeol.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanbyeol.list.adapter.StudentRecyclerAdapter
import com.hanbyeol.list.databinding.FragmentMainListBinding
import com.hanbyeol.list.models.StudentModel

class MainListFragment : Fragment() {

    private lateinit var binding: FragmentMainListBinding
    private val stViewModel: StudentModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.studentList
        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = StudentRecyclerAdapter(stViewModel.studentList)
        recyclerView.adapter = adapter
    }
}