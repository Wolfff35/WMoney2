package com.wolff.wmoney2.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import com.wolff.wmoney2.adapters.MainMenu_list_item_adapter;
import com.wolff.wmoney2.R;
import com.wolff.wmoney2.tools.DebugTools;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainMenu_fragment extends ListFragment {
    private String[] mMenuData;
    private TypedArray mMenuIcons;
    private MainMenu_fragment_listener listener;
    public interface MainMenu_fragment_listener{
        void onMainMenuItemClick(int index);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMenuData = getResources().getStringArray(R.array.main_menu_items);
        mMenuIcons = getResources().obtainTypedArray(R.array.main_menu_icons);
        DebugTools.Log("mIcons",mMenuIcons.toString());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,mMenuData);
        //getListView().setDivider(getResources().getColor(R.color.colorPrimaryDark));

        ColorDrawable divColor =new ColorDrawable(Color.DKGRAY);
        getListView().setDivider(divColor);
        getListView().setDividerHeight(2);
        ListAdapter adapter = new MainMenu_list_item_adapter(getContext(), mMenuData, mMenuIcons);
        setListAdapter(adapter);

         getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 listener.onMainMenuItemClick(position);
             }
         });

    }

    public MainMenu_fragment() {
    }
    public static MainMenu_fragment newInstance(){
        MainMenu_fragment fragment = new MainMenu_fragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (MainMenu_fragment_listener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
