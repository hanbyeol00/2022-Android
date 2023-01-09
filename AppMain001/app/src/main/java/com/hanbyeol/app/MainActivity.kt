package com.hanbyeol.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hanbyeol.app.layout.QnA.QnAFragment
import com.hanbyeol.app.layout.community.CommunityFragment

import com.hanbyeol.app.databinding.ActivityMainBinding
import com.hanbyeol.app.layout.*
import com.hanbyeol.app.layout.community.WriterFragment
import com.hanbyeol.app.layout.login.LoginFragment
import com.hanbyeol.app.layout.main.MainFragment
import com.hanbyeol.app.layout.map.MapFragment
import com.hanbyeol.app.layout.mini_game.MiniGameFragment
import com.hanbyeol.app.layout.mypage.MyPageFragment
import com.hanbyeol.app.layout.writing.WritingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_main ->{
                    changFragment(FRAGMENT_MAIN)
                    true
                }
                R.id.nav_writing -> {
                    changFragment(FRAGMENT_WRITING)
                    true
                }
                R.id.nav_mini_game -> {
                    changFragment(FRAGMENT_MINIGAME)
                    true
                }
                R.id.nav_login ->{
                    changFragment(FRAGMENT_LOGIN)
                    true
                }
                else -> false
            }
        }
    }

    fun changFragment(fragmentName: String){
        val fragment : Fragment  = when(fragmentName){
            FRAGMENT_COMMUNITY -> CommunityFragment()
            FRAGMENT_MAIN -> MainFragment()
            FRAGMENT_LOGIN -> LoginFragment()
            FRAGMENT_MAP -> MapFragment()
            FRAGMENT_MYPAGE -> MyPageFragment()
            FRAGMENT_MINIGAME -> MiniGameFragment()
            FRAGMENT_QNA -> QnAFragment()
            FRAGMENT_WRITING -> WritingFragment()
            FRAGMENT_WRITER -> WriterFragment()
            else -> MainFragment()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainerView.id, fragment)
            .commit()
    }
}
