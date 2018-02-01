package com.wolff.wmoney2.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.wolff.wmoney2.localdb.DbGetData;
import com.wolff.wmoney2.model.WBase;

import java.util.ArrayList;

/**
 * Created by wolfff on 01.02.18.
 */

public class List_items_fragment<T extends WBase> extends AList_fragment {
    private ArrayList<T> mList;
    private List_items_fragment_listener listener;

    public interface List_items_fragment_listener{
        void onItemClick();
    }
    public static<T extends WBase> List_items_fragment newInstance(){
        List_items_fragment<T> fragment = new List_items_fragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mList = DbGetData.get(getContext()).getList(T.);
    }

    @Override
    public void onResume() {
        super.onResume();
        //mAccountList = DataLab.get(getContext()).getWAccountList(getContext());
        onActivityCreated(null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ListAdapter adapter = new Adapter_AccountList(getContext(),mAccountList);
        //setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //    listener.onAccountItemClick(mAccountList.get(position));
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
