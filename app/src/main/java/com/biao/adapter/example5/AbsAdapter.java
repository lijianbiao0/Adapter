package com.biao.adapter.example5;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsAdapter<T,H> extends BaseAdapter {
    List<T> data;
    Context mContext;
    LayoutInflater inflater;

    public AbsAdapter(Context mContext) {
        this.mContext = mContext;
        this.inflater = LayoutInflater.from(mContext);
        this.data = new ArrayList<>();
    }

    public void addElement(T data) {
        this.data.add(data);
    }

    public void addElementS(List<T> data) {
        this.data.addAll(data);
    }

    public void remove(T data) {
        this.data.remove(data);
    }

    public void removes(List<T> data) {
        this.data.removeAll(data);
    }

    public void removeAll() {
        this.data.clear();
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        H hd = null;
        if(convertView==null){
            convertView = getInflater().inflate(getLayoutId(),parent,false);
            hd = createHolder(convertView);
            convertView.setTag(hd);
        }else {
            hd= (H)convertView.getTag();
        }
        bindData(position,hd);

        return convertView;
    }
    public abstract int getLayoutId();
    public abstract H createHolder(View convertView);
    public abstract void bindData(int position,H holder);


}
