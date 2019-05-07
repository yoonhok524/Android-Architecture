package com.youknow.movie.ui.common;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridItemDecoration extends RecyclerView.ItemDecoration {

    private final int padding;

    public GridItemDecoration(int padding) {
        this.padding = padding / 2;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if (parent.getPaddingLeft() != padding) {
            parent.setPadding(padding, padding, padding, padding);
            parent.setClipToPadding(false);
        }

        outRect.top = padding;
        outRect.bottom = padding;
        outRect.left = padding;
        outRect.right = padding;
    }
}
