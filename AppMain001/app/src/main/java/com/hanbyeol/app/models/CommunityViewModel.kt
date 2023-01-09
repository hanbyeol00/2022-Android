package com.hanbyeol.app.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hanbyeol.community.data.Community
import com.hanbyeol.student.data.CommunityStringList


const val C_NUM = 0
const val C_NAME = 1
const val C_DEPT = 2
const val C_GRADE = 3
const val C_ADDR = 5
const val C_TEL = 6

class CommunityViewModel : ViewModel() {

    private val _communityList = mutableListOf<Community>()

    val communityList = MutableLiveData<List<Community>>()

    fun add() {
        val communityString = CommunityStringList.random()
        val items : List<String> = communityString.split(":")

    val community = Community(
        cNum = items[C_NUM],
        cName = items[C_NAME],
        cDept = items[C_DEPT],
        cAddr = items[C_ADDR],
        cTel = items[C_TEL],
        cGrade = items[C_GRADE].toInt()
    )
    _communityList.add(community)
    communityList.value = _communityList
}
}