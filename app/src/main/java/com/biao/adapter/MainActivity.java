package com.biao.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.biao.adapter.example3.bean.User;
import com.biao.adapter.example8.AbsAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ListView lv = findViewById(R.id.lv);
//        ArrayList<User> data = new ArrayList<>();
//        data.add(new User("李建彪"));
//        data.add(new User("李建彪"));
//        data.add(new User("李建彪"));
//        data.add(new User("李建彪"));
//        data.add(new User("李建彪"));
//        data.add(new User("李建彪"));
//        BaseAdapter adapter = new BaseAdapter(this);
//        adapter.addElementS(data);
//        lv.setAdapter(adapter);


        ListView lv = findViewById(R.id.lv);
        ArrayList<User> data = new ArrayList<>();
        data.add(new User("李建彪"));
        data.add(new User("李建彪"));
        data.add(new User("李建彪"));
        data.add(new User("李建彪"));
        data.add(new User("李建彪"));
        data.add(new User("李建彪"));
        AbsAdapter<User> adapter = new AbsAdapter<User>(this, R.layout.list_item) {
            @Override
            public void convertView(int position, User bean, ViewHolder holder) {
//                holder.getView(R.id.name)//获得View
                holder.setText(R.id.name, bean.getName());//可扩展ViewHolder
            }
        };
        adapter.addElementS(data);
        lv.setAdapter(adapter);

    }
}