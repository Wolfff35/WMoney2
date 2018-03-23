package com.wolff.wmoney2.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wolff.wmoney2.R;
import com.wolff.wmoney2.model.WBase;
import com.wolff.wmoney2.tools.UITools;

import java.util.ArrayList;

/**
 * Created by wolfff on 07.02.18.
 */

public class Adapter_ListItem<T extends WBase> extends BaseAdapter {
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<T> mList;

    public Adapter_ListItem(Context context, ArrayList<T> list){
        mContext=context;
        mList=list;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view=mInflater.inflate(R.layout.list_item_adapter,parent,false);
        }
        T account = getItem(position);
        return new UITools().getAdapterView(view,account);
        //return view;
    }}
