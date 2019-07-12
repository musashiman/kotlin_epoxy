package com.example.semoto.epoxysamples.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.semoto.epoxysamples.databinding.FragmentSimpleEpoxyBinding
import com.example.semoto.epoxysamples.epoxycontroller.SimpleEpoxyListController


/**
 * Epoxyを利用したシンプルなリスト表示
 *
 */
class SimpleEpoxyFragment : Fragment() {

    private lateinit var binding: FragmentSimpleEpoxyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSimpleEpoxyBinding.inflate(inflater)

        val controller = SimpleEpoxyListController()
        controller.setData(listOf(
            "A","B","C","D","E","F"
        ))
        binding.simpleTextEpoxyRecyclerView.setController(controller)

        getSupportActionBar()?.title = "Simple Epoxy Example"

        return binding.root
    }


}
