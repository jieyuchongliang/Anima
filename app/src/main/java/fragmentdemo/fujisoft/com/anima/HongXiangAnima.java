package fragmentdemo.fujisoft.com.anima;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class HongXiangAnima extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hong_xiang_anima);
        imageView = (ImageView) findViewById(R.id.iv_hong_xiang);

        //鸿翔式组合动画的第一种表现形式
        //步骤：1，ofFloat方法中的第二个参数任意写，只有不是系统的就可以。
        //      2，调用animator的addUpdateListener方法，添加监听。
        //      3，在回调监听里获取Float类型的对象，对此对象进行操作，添加动画合集。
//        @SuppressLint("ObjectAnimatorBinding")
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "zhy", 1.0f, 0.0f)
//                .setDuration(2000);
//        animator.start();
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float cVal = (Float) animation.getAnimatedValue();
//                imageView.setAlpha(cVal);
//                imageView.setScaleX(cVal);
//                imageView.setScaleY(cVal);
//            }
//        });

        //鸿翔式组合动画的第二种表现形式：
        PropertyValuesHolder pvhX = PropertyValuesHolder.ofFloat("alpha", 1f,
                0f, 1f);
        PropertyValuesHolder pvhY = PropertyValuesHolder.ofFloat("scaleX", 1f,
                0, 1f);
        PropertyValuesHolder pvhZ = PropertyValuesHolder.ofFloat("scaleY", 1f,
                0, 1f);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(imageView, pvhX, pvhY, pvhZ).setDuration(3000);
        animator.setRepeatCount(-1);
        animator.start();
    }
}
