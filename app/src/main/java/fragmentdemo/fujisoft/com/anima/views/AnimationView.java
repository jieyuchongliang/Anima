package fragmentdemo.fujisoft.com.anima.views;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * @author jren
 */
public class AnimationView extends View {
    private Paint mPaint;
    private float mRadius = 30;
    private Point currentPoint;

    public AnimationView(Context context) {
        this(context, null);
    }

    public AnimationView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AnimationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Style.FILL);
        mPaint.setAntiAlias(true);
        if (currentPoint == null) {
            startAnimationMotion();// 执行动画
        }
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaint);
        mPaint.setColor(Color.MAGENTA);
        canvas.drawCircle(currentPoint.getX(), currentPoint.getY(), mRadius, mPaint);
    }

    /**
     * 小球动画
     */
    private void startAnimationMotion() {
        Point startPoint = new Point(0, getHeight() / 2);
        Point endPoint = new Point(getWidth() - mRadius, getHeight() / 2);
        ValueAnimator animator = ValueAnimator.ofObject(new OscillationEvaluator(), startPoint, endPoint);
        animator.setDuration(2000).setRepeatCount(-1);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(new AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setInterpolator(new LinearInterpolator());//设置插值器
        animator.start();
    }


    /**
     * 等幅振荡
     */
    class OscillationEvaluator implements TypeEvaluator {
        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            Point startPoint = (Point) startValue;
            Point endPoint = (Point) endValue;
            float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());//x坐标线性变化
            float y = 120 * (float) (Math.sin(0.01 * Math.PI * x)) + getHeight() / 2;//y坐标取相对应函数值
            return new Point(x, y);
        }
    }
}
