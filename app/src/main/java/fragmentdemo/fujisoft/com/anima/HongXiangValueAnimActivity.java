package fragmentdemo.fujisoft.com.anima;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HongXiangValueAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private RelativeLayout parentLayout;
    private Button btnVertical, btnPaoWuXian;
    private int mScreenHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hong_xiang_value_anim);
        imageView = (ImageView) findViewById(R.id.iv_yuan);
        btnVertical = (Button) findViewById(R.id.btn_vertical);
        btnPaoWuXian = (Button) findViewById(R.id.pao_wu_xian);
        parentLayout = (RelativeLayout) findViewById(R.id.parent);
        btnVertical.setOnClickListener(this);
        btnPaoWuXian.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vertical:
                verticalRun();
                break;
            case R.id.pao_wu_xian:
                break;
            default:
                break;
        }
    }

    private static final String TAG = "HongXiangValueAnimActiv";
    /**
     * 自由落体
     *
     */
    public void verticalRun() {
        ValueAnimator animator = ValueAnimator.ofFloat(0,parentLayout.getHeight() - imageView.getHeight());
        animator.setTarget(imageView);
        animator.setDuration(1000).start();
        animator.setInterpolator(new AnticipateInterpolator());
        //      animator.setInterpolator(value)
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                imageView.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
    }
}
