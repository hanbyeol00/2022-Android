package com.hanbyeol.list.models

/**
 * data class
 *
 *
 *
 *
 *
 *
 * Java 와 같은 언어에는 data class 같은 개념이 없다
 * Java 와 같은 언어에서 일반 class 를 data class 처럼
 * 사용하기 위하여 이름 끝에 Dto 라는 접미사를 붙여서 구분하였다
 * DTO : Data Transfer Object : 데이터를 함수간에 이동할때
 *      사용하는 객체 라는 의미
 * VO : Value Object : DTO 와 거의 유사한 성질인데 사용용도가
 *      약간 다름
 */
// "00126:매재찬:경제학:2:1:울산광역시 울주군 문수로382:010-6239-1705",
data class StudentDto(
    val num: String? = null,
    val name: String? = null,
    val dept: String? = null,
    val grade: Int? = 0,
    val address: String? = null,
    val tel: String? = null,
)
