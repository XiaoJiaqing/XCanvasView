package com.xjq.xcanvasview.sample;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xjq.xcanvasview.XCanvasSurfaceView;
import com.xjq.xcanvasview.XCanvasView;
import com.xjq.xcanvasview.listen.OnCanvasViewPaintListen;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    XCanvasView canvasView1;
    XCanvasView canvasView2;
    XCanvasSurfaceView canvasSurfaceView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        canvasView1 = (XCanvasView) findViewById(R.id.canvasView);
        canvasView2 = (XCanvasView) findViewById(R.id.canvasView2);
        canvasSurfaceView3 = (XCanvasSurfaceView) findViewById(R.id.canvasSurfaceView);

        canvasView1.setOnCanvasViewPaintListen(new OnCanvasViewPaintListen() {
            @Override
            public void OnCanvasViewPaint(Canvas canvas) {

                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(5);
                Random random = new Random();
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                for (int i = 1; i < 20; i++) {
                    int nexValue = random.nextInt(200);
                    canvas.drawLine(width / 20 * i, height / 2 - nexValue / 2, width / 20 * i, height / 2 + nexValue / 2, paint);
                }
            }
        });

        canvasView2.setOnCanvasViewPaintListen(new OnCanvasViewPaintListen() {
            @Override
            public void OnCanvasViewPaint(Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(5);
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                final int centerY = height / 2;
                int x = 0;
                while (x < width) {
                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(5);
                    double rad = x * Math.PI / 180;//角度转换成弧度
                    int y = (int) (centerY - Math.sin(rad) * 100);
                    canvas.drawPoint(x, y, paint);
                    x++;
                }
            }
        });


        canvasSurfaceView3.setOnCanvasViewPaintCallback(new OnCanvasViewPaintListen() {
            @Override
            public void OnCanvasViewPaint(Canvas canvas) {
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStyle(Paint.Style.FILL);
                paint.setStrokeWidth(5);
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                final int centerY = height / 2;
                final int centerX = width / 2;
                Path path = new Path();
                path.moveTo(0, height);
                int x = 0;
                while (x < width) {
                    paint.setColor(Color.BLUE);
                    paint.setStrokeWidth(5);
                    double rad = x * Math.PI / 180;//角度转换成弧度
                    int y = (int) (centerY - Math.sin(rad) * 100);
                    //canvas.drawPoint(x, y, paint);
                    path.lineTo(x, y);
                    x++;
                }
                path.lineTo(width, height);
                canvas.drawPath(path, paint);
            }
        });
    }
}
