package com.hanbyeol.student.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hanbyeol.student.data.Student
import com.hanbyeol.student.data.studentStringList

// 배열의 index 를 미리 변수로 설정하기
const val ST_NUM = 0
const val ST_NAME = 1
const val ST_DEPT = 2
const val ST_GRADE = 3
const val ST_ADDR = 5
const val ST_TEL = 6

class StudentViewModel : ViewModel() {

    /**
     * 학생정보 리스트를 관리할 data
     */
    private val _studentList = mutableListOf<Student>()

    /**
     * 원본 데이터는 List<Student> 인데
     * 이 데이터를 viewModel 에서 관리하기 위하여
     * List<Student> 를 MutableLiveData 로 감싸준다
     */
    val studentList = MutableLiveData<List<Student>>()
    init {
        // _studentList.add(Student())
        // studentList.value = _studentList
    }

    fun add() {
        // StudentData 에 있는 학생정보 문자열을 random 으로 가져오기
        /**
         * PC 코드에서 사용하는 random() 함수들
         * 컴퓨터의 시간값을 내부에서 연산을 통해 어떤 값을 만들고
         * 그 값을 index 로 하여 random 값을 생성한다
         *
         * 때문에 PC 코드의 random() 함수가 return 하는 값을
         * 의사난수, 유사난수 라고 한다
         * 중복된 값이 많이 나타난다다         */
        val studentString = studentStringList.random()
        val items : List<String> = studentString.split(":")

        val student = Student(
            stNum = items[ST_NUM],
            stName = items[ST_NAME],
            stDept = items[ST_DEPT],
            stAddr = items[ST_ADDR],
            stTel = items[ST_TEL],
            stGrade = items[ST_GRADE].toInt()
        )
        _studentList.add(student)
        studentList.value = _studentList
    }
}