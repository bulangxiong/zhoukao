package com.bwei.android_zhangxiaokang20181203;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView soushuo;
    private ImageView shanchu;
    private Button quxiao;
    private ZuiJinSouShuoView zuiJinSouShuoView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soushuo = findViewById(R.id.image_soushuo);
        shanchu = findViewById(R.id.image_shanchu);
        quxiao = findViewById(R.id.btn_quxiao);
        editText = findViewById(R.id.edit_wen);
        zuiJinSouShuoView = findViewById(R.id.zuijin_layout);
        soushuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                zuiJinSouShuoView.addTextView(s);
            }
        });
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zuiJinSouShuoView.removeAllViews();
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(null);
            }
        });
//        zuiJinSouShuoView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for (int i = 0; i <v.getHeight() ; i++) {
//                    Toast.makeText(MainActivity.this,zuiJinSouShuoView.toString(),Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }
}
