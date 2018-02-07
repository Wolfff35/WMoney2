package com.wolff.wmoney2.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;

import com.wolff.wmoney2.localdb.DbGetData;
import com.wolff.wmoney2.model.WBase;
import com.wolff.wmoney2.tools.DebugTools;
import com.wolff.wmoney2.tools.UITools;

import java.util.ArrayList;

/**
 * Created by wolfff on 01.02.18.
 */

public class List_items_fragment<T extends WBase> extends AList_fragment {
    private ArrayList<T> mList;
    private List_items_fragment_listener listener;
    private  String mTableName;
    public interface List_items_fragment_listener{
        void onItemClick(int item_position);
    }
    public static<T extends WBase> List_items_fragment newInstance(String table_name){
         Bundle args  = new Bundle();
        args.putString("TABLE_NAME",table_name);
        List_items_fragment<T> fragment = new List_items_fragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTableName = getArguments().getString("TABLE_NAME");
        mList = new DbGetData<T>(getContext()).getList(mTableName);
        DebugTools.Log("onCreate","000");
    }

    @Override
    public void onResume() {
        super.onResume();
        mList = new DbGetData<T>(getContext()).getList(mTableName);
        getActivity().setTitle(new UITools().getListTitle(mTableName));
        onActivityCreated(null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Adapter_ListItem<T> adapter = new Adapter_ListItem(getContext(),mList);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onItemClick(position);
            }
        });
    }

    @Override
 public void onAttach(Context context) {
     super.onAttach(context);
     listener = (List_items_fragment_listener) context;
 }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
