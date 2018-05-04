package com.biao.adapter.example3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biao.adapter.R;
import com.biao.adapter.example3.bean.User;

import java.util.List;

public class BaseAdapter extends android.widget.BaseAdapter {
    List<User> data;
    Context mContext;
    LayoutInflater inflater;

    public BaseAdapter(Context mContext, List<User> data ) {
        this.data = data;
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public User getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item,parent,false);
            vh = new ViewHolder(convertView,getItem(position));
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.name.setText(getItem(position).getName());
        return convertView;
    }

    class ViewHolder {
        TextView name;
        public ViewHolder(View convertView,User user) {
            name = convertView.findViewById(R.id.name);
            this.name.setText("");
        }
    }
}
