package com.xjq.xcanvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import com.xjq.xcanvasview.listen.OnCanvasViewPaintListen;

/**
 * Created by ziv on 2017/7/17.
 */

public class XCanvasView extends View {


    private OnCanvasViewPaintListen onCanvasViewPaintListen;

    public XCanvasView(Context context) {
        super(context);
    }

    public XCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (onCanvasViewPaintListen != null)
            onCanvasViewPaintListen.OnCanvasViewPaint(canvas);
    }

    public void setOnCanvasViewPaintListen(OnCanvasViewPaintListen onCanvasViewPaintListen) {

        this.onCanvasViewPaintListen = onCanvasViewPaintListen;

    }
}
