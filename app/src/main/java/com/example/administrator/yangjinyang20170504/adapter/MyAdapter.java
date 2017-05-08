package com.example.administrator.yangjinyang20170504.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.yangjinyang20170504.DBManager;
import com.example.administrator.yangjinyang20170504.MyCar;
import com.example.administrator.yangjinyang20170504.R;
import com.example.administrator.yangjinyang20170504.db.car;

import java.util.List;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

public class MyAdapter extends BaseAdapter {
    private List<car> mlist;
    private Context context;

    public MyAdapter(List<car> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mlist.isEmpty() ? 0 : mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.muban, null);
            holder.muban_name = (TextView) convertView.findViewById(R.id.muban_name);
            holder.muban_price = (TextView) convertView.findViewById(R.id.muban_price);
            holder.muban_content = (TextView) convertView.findViewById(R.id.muban_content);

            convertView.setTag(holder);


        } else {

            holder = (Holder) convertView.getTag();
        }
        DBManager dbManager = new DBManager(context);
        mlist = dbManager.queryUserList();
        car car = mlist.get(position);
        holder.muban_name.setText(car.getName() + "");
        holder.muban_content.setText(car.getContent() + "");
        holder.muban_price.setText(car.getPrice() + "");


        return convertView;
    }

    class Holder {
        private TextView muban_name, muban_content, muban_price;

    }
}
