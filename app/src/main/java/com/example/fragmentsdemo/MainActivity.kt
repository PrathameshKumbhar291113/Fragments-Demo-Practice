package com.example.fragmentsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.fragmentsdemo.databinding.ActivityMainBinding
import com.example.fragmentsdemo.fragment.FirstFragment
import com.example.fragmentsdemo.fragment.SecondFragment
import com.example.fragmentsdemo.fragment.StaticFragment
import splitties.activities.start

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(StaticFragment())
        binding.button.setOnClickListener {
            replaceFragment(FirstFragment())
        }
        binding.button2.setOnClickListener {
            replaceFragment(SecondFragment())
        }
        binding.button3.setOnClickListener {
            start<MainActivity2>()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}