package com.biao.adapter.example7;

import android.content.Context;

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
    public void bindData(int position, User bean, ViewHolder holder) {
//        holder.getView(R.id.name);//获得控件
        holder.setText(R.id.name,bean.getName());//可扩展ViewHolder
    }
}
