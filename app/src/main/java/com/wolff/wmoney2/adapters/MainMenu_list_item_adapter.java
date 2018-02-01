package com.wolff.wmoney2.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.wolff.wmoney2.R;
import com.wolff.wmoney2.tools.DebugTools;

/**
 * Created by wolfff on 30.01.18.
 */

public class MainMenu_list_item_adapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private String[] mList;
    private TypedArray mIcons;

    public MainMenu_list_item_adapter(Context context, String[] items, TypedArray icons) {
        mContext = context;
        mList = items;
        mIcons = icons;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.length;
    }

    @Override
    public Object getItem(int position) {
        return mList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.mainmenu_list_item_adapter, parent, false);
            ImageButton ibAdd = view.findViewById(R.id.ibAdd);
            ibAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DebugTools.Log("CLICK ADD BUTTON", "" + position);
                }
            });


            TextView tvName = view.findViewById(R.id.tvName);
            tvName.setText(mList[position]);
            ImageView ivIcon = view.findViewById(R.id.ivIcon);
            ivIcon.setImageDrawable(mIcons.getDrawable(position));
             if (position < 3) {
                ibAdd.setVisibility(View.VISIBLE);
             } else {
                ibAdd.setVisibility(View.INVISIBLE);
             }

        }

        return view;
    }
}
