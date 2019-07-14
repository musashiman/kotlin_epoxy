package com.example.semoto.epoxysamples.epoxycontroller

import android.graphics.Color
import android.support.v7.widget.CardView
import android.view.View
import com.airbnb.epoxy.Typed2EpoxyController
import com.example.semoto.epoxysamples.R
import com.example.semoto.epoxysamples.TextHeaderBindingModel_
import com.example.semoto.epoxysamples.TextItemBindingModel_

class SingleSelectionEpoxyListController: Typed2EpoxyController<List<String>, List<String>>() {

    private var selectedItem = Pair(-1, -1)

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
                    .text(text).onBind { model, view, position ->
                        val id = model.id()
                        val selectedItenIndex = Pair(index, indexItem)
                        val cardView = view.dataBinding.root.findViewById<CardView>(R.id.textCard)
                        if (selectedItenIndex == selectedItem) {
                            cardView.setCardBackgroundColor(Color.LTGRAY)
                        } else {
                            cardView.setCardBackgroundColor(Color.WHITE)
                        }
                    }
                    .listener(View.OnClickListener {
                        if (selectedItem != Pair(index, indexItem)) {
                            selectedItem = Pair(index, indexItem)
                            setData(headers, items)
                        }
                    })
                    .addTo(this)
            }
        }
    }
}