package com.xjq.xcanvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ziv on 2017/7/17.
 */

public class XCanvasView extends View {

    public interface OnCanvasViewPaintCallback {
        void OnCanvasViewPaint(Canvas canvas);
    }

    private OnCanvasViewPaintCallback onCanvasViewPaintCallback;

    public XCanvasView(Context context) {
        super(context);
    }

    public XCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        onCanvasViewPaintCallback.OnCanvasViewPaint(canvas);
    }

    public void setOnCanvasViewPaintCallback(OnCanvasViewPaintCallback onCanvasViewPaintCallback) {

        this.onCanvasViewPaintCallback = onCanvasViewPaintCallback;

    }
}
