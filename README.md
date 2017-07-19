# XCanvasView
一个基于Android的简化绘图操作的库


## 简介
一般情况，我们要绘制图形的做法是继承View，然后重写其onDraw()方法. XCanvasView可以让我们略过这些繁琐步骤，更加专注于图形绘制算法与逻辑.



## Download
打开项目根目录下的build.gradle，添加以下内容：

	allprojects {

    repositories {
       	...
       	maven { url 'https://jitpack.io' }
    }
	}
  
  
打开APP的build.gradle，添加以下内容：

	dependencies {
    	...
    	compile 'com.github.XiaoJiaqing:XCanvasView:v0.1.1'
	}
	
	
## 用法
一般情况下使用XCanvasView即可，如果需要绘制的图形比较复杂，耗时较长，可以使用 XCanvasSurfaceView

   
    <com.xjq.xcanvasview.XCanvasView
        android:id="@+id/canvasView"
        android:layout_width="match_parent"
        android:layout_height="300dp"
        android:background="#99e67e22" />
               

    canvasView.setOnCanvasViewPaintListen(new OnCanvasViewPaintListen() {
            @Override
            public void OnCanvasViewPaint(Canvas canvas) {

                Paint paint = new Paint();
                paint.setColor(Color.BLUE);
                paint.setStrokeWidth(5);
                
                //绘制图形的算法与逻辑
                /*
                Random random = new Random();
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                for (int i = 1; i < 20; i++) {
                    int nexValue = random.nextInt(200);
                    canvas.drawLine(width / 20 * i, height / 2 - nexValue / 2, width / 20 * i, height / 2 + nexValue / 2, paint);
                }
                */
            }
        });


