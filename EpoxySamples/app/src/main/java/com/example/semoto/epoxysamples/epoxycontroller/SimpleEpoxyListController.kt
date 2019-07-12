package com.example.semoto.epoxysamples.epoxycontroller

import com.airbnb.epoxy.TypedEpoxyController
import com.example.semoto.epoxysamples.TextItemBindingModel_

class SimpleEpoxyListController: TypedEpoxyController<List<String>>() {

    override fun buildModels(data: List<String>?) {

        data ?: return

        data.forEachIndexed { index, text ->

            TextItemBindingModel_()
                .id("TextItemBindingModel_", index.toLong())
                .text(text)
                .addTo(this)
        }
    }
}