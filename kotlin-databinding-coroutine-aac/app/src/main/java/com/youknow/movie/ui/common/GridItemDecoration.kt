package com.youknow.movie.ui.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridItemDecoration(private var padding: Int) : RecyclerView.ItemDecoration() {

    init {
        padding /= 2
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.paddingLeft != padding) {
            parent.setPadding(padding, padding, padding, padding)
            parent.clipToPadding = false
        }

        outRect.apply {
            top = padding
            bottom = padding
            left = padding
            right = padding
        }
    }
}