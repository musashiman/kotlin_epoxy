package com.example.semoto.epoxysamples.epoxycontroller

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.semoto.epoxysamples.TextHeaderBindingModel_
import com.example.semoto.epoxysamples.TextItemBindingModel_

class SimpleEpoxyListController: Typed2EpoxyController<List<String>, List<String>>() {

    override fun buildModels(
        headers: List<String>?,
        items: List<String>?
    ) {

        headers ?: return
        items ?: return

        headers.forEachIndexed { index, header ->

            TextHeaderBindingModel_()
                .id(header, index.toLong())
                .text(header)
                .addTo(this)

            items.forEachIndexed { indexItem, text ->

                TextItemBindingModel_()
                    .id("TextItemBindingModel_$index", indexItem.toLong())
                    .text(text)
                    .addTo(this)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val controller = SimpleEpoxyListController()

        // setData()でデータを渡すとbuildModels()が呼ばれる
        controller.setData(
            listOf(
                "header1","header2"
            ),
            listOf(
                "A","B","C","D","E","F"
            )
        )

        // EpoxyRecyclerViewに4.で自作したTypedEpoxyControllerを継承したControllerをセット
        binding.simpleTextEpoxyRecyclerView.setController(controller)

        return binding.root
    }
}