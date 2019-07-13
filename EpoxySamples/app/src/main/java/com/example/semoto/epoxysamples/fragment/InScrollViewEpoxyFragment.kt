package com.example.semoto.epoxysamples.fragment


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.semoto.epoxysamples.databinding.FragmentInScrollViewEpoxyBinding
import com.example.semoto.epoxysamples.epoxycontroller.SimpleEpoxyListController


/**
 * ScrollView内でEpoxyを利用したシンプルなリスト表示
 *
 */
class InScrollViewEpoxyFragment : Fragment() {

    private lateinit var binding: FragmentInScrollViewEpoxyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInScrollViewEpoxyBinding.inflate(inflater)

        val controller = SimpleEpoxyListController()
        controller.setData(
            listOf(
                "header1", "header2", "header3", "header4", "header5", "header6"
            ),
            listOf(
                "A", "B", "C", "D", "E", "F", "G"
            )
        )
        binding.inScrollViewTextEpoxyRecyclerView.setController(controller)

        getSupportActionBar()?.title = "In ScrollView Epoxy Example"

        return binding.root
    }


}
