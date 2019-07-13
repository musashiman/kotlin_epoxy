package com.example.semoto.epoxysamples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.semoto.epoxysamples.fragment.SimpleEpoxyFragment

class MainActivity : AppCompatActivity() {

    private val exampleCase = ExampleCase.SIMPLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        when (exampleCase) {
            ExampleCase.SIMPLE -> {
                setFragment(SimpleEpoxyFragment())
            }
            ExampleCase.IN_SCROLLVIEW -> {}
        }
    }

    private fun setFragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}

enum class ExampleCase {
    SIMPLE, IN_SCROLLVIEW
}