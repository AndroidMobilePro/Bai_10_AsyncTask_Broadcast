package com.proteam.bai_10_asynctask_broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Test {

    private TextView tvContent;
    ExampleBroadcast exampleBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAsync = (Button) findViewById(R.id.btnSyncTask);
        Button btnBroadcast = (Button) findViewById(R.id.btnBroadcast);
        Button btnStartActivity = (Button) findViewById(R.id.btnStartActivity);
        tvContent = (TextView) findViewById(R.id.tvText);

        exampleBroadcast = new ExampleBroadcast();
        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExampleAsysnTask exampleAsysnTask = new ExampleAsysnTask(tvContent, MainActivity.this);
                exampleAsysnTask.execute(10);
            }
        });

        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
                sendBroadcast(intent);
            }
        });

        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void updateUI(String s) {
        tvContent.setText(s);
    }
}
