package com.seoleo.slovaruzru.ui.adapter

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class DictionaryItemDecoration(
    private val viewType: Int,
    private val divider: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val adapter = parent.adapter ?: return
        val currentPosition = parent.getChildAdapterPosition(view)
            .takeIf { it != RecyclerView.NO_POSITION }
            ?: parent.getChildViewHolder(view).oldPosition

        val isPrevTargetView = adapter.isPrevTargetView(currentPosition, viewType)

        with(outRect) {
            top = if (isPrevTargetView) divider + 4 else divider
            left = divider * 2
            right = divider * 2
            bottom = divider
        }
    }

    private fun RecyclerView.Adapter<*>.isPrevTargetView(
        currentPosition: Int,
        viewType: Int,
    ) = currentPosition != 0 && getItemViewType(currentPosition - 1) == viewType
}
