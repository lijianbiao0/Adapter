package com.biao.adapter.example4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biao.adapter.R;
import com.biao.adapter.example3.bean.User;

public class BaseAdapter extends AbsAdapter<User> {


    public BaseAdapter(Context mContext) {
        super(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView == null){
            convertView = getInflater().inflate(R.layout.list_item,parent,false);
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

        }
    }
}
