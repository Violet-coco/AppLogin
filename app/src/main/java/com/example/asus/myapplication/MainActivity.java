package com.example.asus.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.asus.myapplication.com.example.bs.utils.CodeUtils;

public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;
    private String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //获取需要展示图片验证码的ImageView
        final ImageView image = (ImageView) findViewById(R.id.image);
        //获取工具类生成的图片验证码对象
        bitmap = CodeUtils.getInstance().createBitmap();
        //获取当前图片验证码的对应内容用于校验
        code = CodeUtils.getInstance().getCode();

        image.setImageBitmap(bitmap);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap = CodeUtils.getInstance().createBitmap();
                code = CodeUtils.getInstance().getCode();
                image.setImageBitmap(bitmap);
                Toast.makeText(MainActivity.this, code, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
