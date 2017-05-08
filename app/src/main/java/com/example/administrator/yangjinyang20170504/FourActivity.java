package com.example.administrator.yangjinyang20170504;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.yangjinyang20170504.db.car;

import static android.R.attr.name;

public class FourActivity extends Activity {
    private EditText ed_name, ed_price, ed_content;
    private Button btn_add;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        ed_name = (EditText) findViewById(R.id.four_add_name);
        ed_price = (EditText) findViewById(R.id.four_add_price);
        ed_content = (EditText) findViewById(R.id.four_add_content);
        dbManager = new DBManager(FourActivity.this);

        btn_add = (Button) findViewById(R.id.four_add_btn);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_ = ed_name.getText().toString();
                String price_ = ed_price.getText().toString();
                String content_ = ed_content.getText().toString();

                if (!(name_.isEmpty() && price_.isEmpty() && content_.isEmpty())) {
                    car car = new car();
                    car.setName(name_ + "");
                    car.setPrice(price_ + "");
                    car.setContent(content_ + "");

                    long l = dbManager.insertUser(car);
                    if (l > 0) {

                        Toast.makeText(FourActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FourActivity.this, TwoActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(FourActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(FourActivity.this, "输入数据有误", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
