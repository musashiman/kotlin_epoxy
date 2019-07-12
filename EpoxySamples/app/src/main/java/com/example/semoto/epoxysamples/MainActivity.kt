package com.example.semoto.epoxysamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.semoto.epoxysamples.fragment.SimpleEpoxyFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SimpleEpoxyFragment()).commit()
    }
}
