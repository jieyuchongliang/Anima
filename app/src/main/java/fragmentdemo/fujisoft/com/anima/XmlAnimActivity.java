package fragmentdemo.fujisoft.com.anima;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class XmlAnimActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_anim);
        imageView = (ImageView) findViewById(R.id.iv);

        //透明度渐变动画
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
//        animator.setTarget(imageView);
//        animator.start();

        //旋转动画
//        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.rotation);
//        animator.setTarget(imageView);
//        animator.start();

        //xml组合动画
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.group);
        animator.setTarget(imageView);
        animator.start();
    }
}
