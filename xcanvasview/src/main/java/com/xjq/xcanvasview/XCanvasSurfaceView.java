package com.xjq.xcanvasview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.xjq.xcanvasview.listen.OnCanvasViewPaintListen;

/**
 * Created by ziv on 2017/7/17.
 */

public class XCanvasSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private boolean mIsRunning;
    private OnCanvasViewPaintListen onCanvasViewPaintListen;

    public XCanvasSurfaceView(Context context) {
        this(context, null);
    }

    public XCanvasSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XCanvasSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mHolder = getHolder();
        mHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsRunning = true;
        new Thread(this).start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsRunning = false;
    }

    @Override
    public void run() {

        while (mIsRunning) {
            draw();
        }
    }

    private void draw() {
        mCanvas = mHolder.lockCanvas();
        if (mCanvas != null) {
            try {
                //使用获得的Canvas做具体的绘制
                if (onCanvasViewPaintListen != null)
                    onCanvasViewPaintListen.OnCanvasViewPaint(mCanvas);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                mHolder.unlockCanvasAndPost(mCanvas);
            }
        }
    }

    public void setOnCanvasViewPaintListen(OnCanvasViewPaintListen onCanvasViewPaintListen) {

        this.onCanvasViewPaintListen = onCanvasViewPaintListen;

    }
}