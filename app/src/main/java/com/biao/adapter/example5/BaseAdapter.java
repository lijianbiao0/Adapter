package com.biao.adapter.example5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.biao.adapter.R;
import com.biao.adapter.example3.bean.User;

public class BaseAdapter extends AbsAdapter<User,BaseAdapter.ViewHolder> {
    public BaseAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    public ViewHolder createHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void bindData(int position, ViewHolder holder) {
        holder.name.setText(getItem(position).getName());
    }


    static class ViewHolder {
        TextView name;
        public ViewHolder(View convertView) {
            name = convertView.findViewById(R.id.name);
        }
    }
}
