package fragmentdemo.fujisoft.com.anima;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;

public class CodeAnimaActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_test);
        //透明度渐变动画
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f, 1f);
//        animator.setDuration(2000);
//        animator.setRepeatCount(-1);//-1表示一直重复显示动画
//        animator.start();

        //旋转动画
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", -30f, 30f,-30f);
//        animator.setDuration(300);
//        animator.setRepeatCount(-1);//-1表示一直重复显示动画
//        animator.start();

        //移动动画
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationX", 0f, -300f, 300f,0f);
//        animator.setDuration(800);
//        animator.setRepeatCount(-1);//-1表示一直重复显示动画
//        animator.start();

        //缩放动画
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 2f, 1f);
        animator.setInterpolator(new AnticipateInterpolator());
        animator.setDuration(800);
        animator.setRepeatCount(-1);//-1表示一直重复显示动画
        animator.start();

        //组合动画
        //沿x轴放大
//        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 2f, 1f);
//        scaleXAnimator.setRepeatCount(-1);
//        //沿y轴放大
//        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 2f, 1f);
//        scaleYAnimator.setRepeatCount(-1);
//        //移动
//        ObjectAnimator translationXAnimator = ObjectAnimator.ofFloat(imageView, "translationX", 0f, 200f, 0f);
//        //透明动画
//        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f, 1f);
//        AnimatorSet set = new AnimatorSet();
//        set.setInterpolator(new AnticipateInterpolator());
//        //同时沿X,Y轴放大，且改变透明度，然后移动
//        set.play(scaleXAnimator).with(scaleYAnimator).with(animator).before(translationXAnimator);
//        //都设置3s，也可以为每个单独设置
//        set.setDuration(800);
//        set.start();
    }
}
