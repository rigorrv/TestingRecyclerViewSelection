package com.example.testingrecyclerviewselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.testingrecyclerviewselection.databinding.*
import com.example.testingrecyclerviewselection.model.mockData
import com.example.testingrecyclerviewselection.screen.LoginFragment

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        getFragment()
        loadInfo()
    }

    private fun getFragment() {
        supportFragmentManager.commit {
            add(R.id.fragment2, LoginFragment(), " Login")
        }
    }

    private fun loadInfo() {
        var myInfo = listOf(mockData()[1])
        myInfo.map {
            it.imagenes.map {
                Log.d("TAG", "loadInfo: ${it}")
            }
        }

    }
}