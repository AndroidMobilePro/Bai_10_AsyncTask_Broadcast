package com.proteam.bai_10_asynctask_broadcast;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    ExampleBroadcast exampleBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button btnRegistry = (Button) findViewById(R.id.btnRegistryBroadcast);

        exampleBroadcast = new ExampleBroadcast();
        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerReceiver(exampleBroadcast, new IntentFilter(
                        "com.tutorialspoint.CUSTOM_INTENT"));
            }
        });
    }
}
