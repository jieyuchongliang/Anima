package fragmentdemo.fujisoft.com.anima;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.btn_code_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CodeAnimaActivity.class));
            }
        });

        findViewById(R.id.btn_xml_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,XmlAnimActivity.class));
            }
        });

        findViewById(R.id.btn_hong_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HongXiangAnima.class));
            }
        });

        findViewById(R.id.btn_valueanim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HongXiangValueAnimActivity.class));
            }
        });

        findViewById(R.id.type_evaluator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TypeEvaluator.class));
            }
        });
    }
}
