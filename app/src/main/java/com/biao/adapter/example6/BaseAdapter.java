package com.biao.adapter.example6;

import android.content.Context;
import android.widget.TextView;

import com.biao.adapter.R;
import com.biao.adapter.example3.bean.User;

public class BaseAdapter extends AbsAdapter<User> {
    public BaseAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    public void bindData(int position, AbsAdapter<User>.ViewHolder holder) {
        TextView tv = holder.getView(R.id.name);
        tv.setText(getItem(position).getName());


    }

}
