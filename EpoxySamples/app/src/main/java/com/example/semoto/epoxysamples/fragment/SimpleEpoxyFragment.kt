package com.example.semoto.epoxysamples.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.epoxy.Typed2EpoxyController
import com.example.semoto.epoxysamples.databinding.FragmentSimpleEpoxyBinding


/**
 * Epoxyを利用したシンプルなリスト表示
 *
 */
class SimpleEpoxyFragment : Fragment() {

    private lateinit var binding: FragmentSimpleEpoxyBinding

    private lateinit var controller: Typed2EpoxyController<List<String>, List<String>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSimpleEpoxyBinding.inflate(inflater)

        controller.setData(
            listOf(
                "header1","header2"
            ),
            listOf(
                "A","B","C","D","E","F"
            )
        )
        binding.simpleTextEpoxyRecyclerView.setController(controller)

        getSupportActionBar()?.title = "Simple Epoxy Example"

        return binding.root
    }

    companion object {

        private var instance: SimpleEpoxyFragment? = null

        fun setController(controller: Typed2EpoxyController<List<String>, List<String>>) : SimpleEpoxyFragment {
            if (instance == null) {
                instance = SimpleEpoxyFragment()
                instance!!.controller = controller
            }
            return instance!!
        }
    }
}
