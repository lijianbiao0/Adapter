package com.biao.adapter.example7;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbsAdapter<T> extends BaseAdapter {
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
        ViewHolder vh;
        if (convertView == null) {
            vh = new ViewHolder();
            convertView = vh.loadConvertView(parent, false);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        T t = getItem(position);
        bindData(position,t,vh);

        return convertView;
    }

    public abstract int getLayoutId();


    public abstract void bindData(int position,T bean, ViewHolder holder);

    public class ViewHolder {
        View convertView;
        HashMap<Integer, View> viewMap = new HashMap<>();

        public ViewHolder() {
        }



        public View loadConvertView( ViewGroup parent, boolean attachToRoot) {
            if(convertView==null){
                convertView= getInflater().inflate(getLayoutId(), parent, attachToRoot);
            }
            return convertView;
        }


        public <V extends View> V getView(int viewId) {
            View view = viewMap.get(viewId);
            if (view == null) {
                view = convertView.findViewById(viewId);
                viewMap.put(viewId, view);
            }
            return (V) view;
        }
        public void setText(int viewId,String text){
            View view = getView(viewId);
            if(view instanceof TextView){
                TextView tv = (TextView) view;
                tv.setText(text);
            }
        }
    }

}
