package com.example.administrator.yangjinyang20170504;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.yangjinyang20170504.adapter.MyAdapter;
import com.example.administrator.yangjinyang20170504.db.car;

import java.util.List;

public class TwoActivity extends Activity {
    private Button mTwo_btn;
    private ListView mTwo_listview;
    private MyAdapter myAdapter;
    private List<car> mlist;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        mTwo_btn = (Button) findViewById(R.id.two_add);
        mTwo_listview = (ListView) findViewById(R.id.two_listview);
        dbManager = new DBManager(TwoActivity.this);

        //打印一下数据库里的东西
        List<car> cars = dbManager.queryUserList();
        for (car car_ : cars) {
            Log.e("数据库name--------------->", car_.getName());

        }


        mlist = dbManager.queryUserList();
        myAdapter = new MyAdapter(mlist, TwoActivity.this);
        myAdapter.notifyDataSetChanged();
        mTwo_listview.setAdapter(myAdapter);

        //点击添加跳转
        mTwo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this, FourActivity.class);
                startActivity(intent);
                finish();
            }
        });


        //listview   Item的单击事件
        mTwo_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(TwoActivity.this, ThreeActivity.class);
                intent1.putExtra("name", mlist.get(position).getName());
                intent1.putExtra("price", mlist.get(position).getPrice());
                intent1.putExtra("content", mlist.get(position).getContent());
                startActivity(intent1);

            }
        });


    }
}
