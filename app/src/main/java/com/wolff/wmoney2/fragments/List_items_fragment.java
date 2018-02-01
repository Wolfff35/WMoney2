package com.wolff.wmoney2.fragments;

import android.content.Context;

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
 //   public static List_items_fragment newInstance(){
 //       List_items_fragment<> fragment = new List_items_fragment();
 //       return
 //   }
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
