package com.hanbyeol.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.hanbyeol.app.databinding.CommunityListItemBinding
import com.hanbyeol.community.data.Community

class CommunityRecyclerAdapter (
    private val communityList : LiveData<List<Community>>// 화면에 보여줄 데이터
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val communityHolder =
                CommunityListItemBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            return CommunityViewHolder(communityHolder)
        }

        // 개별 데이터와 view 를 연결하는 함수
        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val item = communityList.value?.get(position)
            val cHolder = holder as CommunityViewHolder
            cHolder.bind(item!!)
        }

        override fun getItemCount(): Int =
            if (communityList.value == null) 0 else communityList.value?.size!!

        fun modifyNotice() {
            notifyDataSetChanged()
        }

        inner class CommunityViewHolder(private val binding: CommunityListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(community: Community) {
                binding.cView = community
            }
        }

}