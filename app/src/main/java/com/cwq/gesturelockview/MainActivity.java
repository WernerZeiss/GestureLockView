package com.cwq.gesturelockview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cwq.gesturelockview.widge.GestureLockView;

public class MainActivity extends AppCompatActivity {
    GestureLockView gestureLockView;
    TextView tv_pwd;
    Button btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureLockView = findViewById(R.id.gestureLockView);
        tv_pwd = findViewById(R.id.tv_pwd);
        btn_reset = findViewById(R.id.btn_reset);

        gestureLockView.setOnFinishListener(new GestureLockView.onFinishListener() {
            @Override
            public void onFinish(String password) {
                tv_pwd.setText(password);
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gestureLockView.reset();
                tv_pwd.setText("");
            }
        });
    }
}
