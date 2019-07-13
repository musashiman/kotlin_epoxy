package com.example.semoto.epoxysamples.epoxycontroller

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.semoto.epoxysamples.TextHeaderBindingModel_
import com.example.semoto.epoxysamples.TextItemBindingModel_

class SimpleEpoxyListController: Typed2EpoxyController<List<String>, List<String>>() {

    override fun buildModels(headers: List<String>?,items: List<String>?) {

        headers ?: return
        items ?: return

        TextHeaderBindingModel_()
            .id(headers[0])
            .text(headers[0])
            .addTo(this)

        items.forEachIndexed { index, text ->

            TextItemBindingModel_()
                .id("TextItemBindingModel_1", index.toLong())
                .text(text)
                .addTo(this)
        }

        TextHeaderBindingModel_()
            .id(headers[1])
            .text(headers[1])
            .addTo(this)

        items.forEachIndexed { index, text ->

            TextItemBindingModel_()
                .id("TextItemBindingModel_2", index.toLong())
                .text(text)
                .addTo(this)
        }
    }
}