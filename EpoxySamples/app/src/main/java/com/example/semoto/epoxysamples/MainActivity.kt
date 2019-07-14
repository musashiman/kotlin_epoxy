package com.example.semoto.epoxysamples

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.semoto.epoxysamples.epoxycontroller.SimpleEpoxyListController
import com.example.semoto.epoxysamples.epoxycontroller.SingleSelectionEpoxyListController
import com.example.semoto.epoxysamples.fragment.InScrollViewEpoxyFragment
import com.example.semoto.epoxysamples.fragment.SimpleEpoxyFragment

class MainActivity : AppCompatActivity() {

    private val exampleCase = ExampleCase.SINGLE_SELECTION

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        when (exampleCase) {
            ExampleCase.SIMPLE -> {
                setFragment(SimpleEpoxyFragment.setController(SimpleEpoxyListController()))
            }
            ExampleCase.IN_SCROLLVIEW -> {
                setFragment(InScrollViewEpoxyFragment())
            }
            ExampleCase.SINGLE_SELECTION -> {
                setFragment(SimpleEpoxyFragment.setController(SingleSelectionEpoxyListController()))
            }
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
    SIMPLE, IN_SCROLLVIEW, SINGLE_SELECTION
}