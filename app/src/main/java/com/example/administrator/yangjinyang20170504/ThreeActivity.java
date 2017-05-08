package com.example.administrator.yangjinyang20170504;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThreeActivity extends Activity {
    private TextView three_text_name, three_text_price, three_text_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String content = intent.getStringExtra("content");

        three_text_name = (TextView) findViewById(R.id.three_name);
        three_text_price = (TextView) findViewById(R.id.three_price);
        three_text_content = (TextView) findViewById(R.id.three_content);

        three_text_name.setText(name);
        three_text_price.setText(price);
        three_text_content.setText(content);


    }
}
