package com.wolff.wmoney2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.wolff.wmoney2.R;

/**
 * Created by wolfff on 01.02.18.
 */

public abstract class AItem_fragment extends Fragment {
    protected boolean mIsNewItem;
    protected boolean mIsEditableItem;
    protected boolean mIsChangedItem;
    protected Menu mOptionsMenu;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
 //       fields_fillData();
 //       fields_setListeners();
//        return container;
//    }
//    protected void fields_fillData(){}
//    protected void fields_setListeners(){}

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        this.mOptionsMenu = menu;
        inflater.inflate(R.menu.menu_item_actions,mOptionsMenu);
        super.onCreateOptionsMenu(mOptionsMenu, inflater);
        setOptionsMenuVisibility();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save: {
                saveItem();
                break;
            }
            case R.id.action_delete: {
                deleteItem();
                break;
            }
            case R.id.action_edit: {
                mIsEditableItem=true;
                setOptionsMenuVisibility();
                setFieldsVisibility();
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void setOptionsMenuVisibility(){
        if(mOptionsMenu!=null){
            MenuItem it_save = mOptionsMenu.findItem(R.id.action_save);
            MenuItem it_del = mOptionsMenu.findItem(R.id.action_delete);
            MenuItem it_edit = mOptionsMenu.findItem(R.id.action_edit);
            it_edit.setVisible(!mIsEditableItem);
            it_save.setVisible(mIsEditableItem&&mIsChangedItem);
            it_del.setVisible(!mIsNewItem);
        }
    }
    protected void setFieldsVisibility(){
    }
    protected void saveItem(){
        updateItemFields();
    }
 //   public boolean isFillingOk() {
 //       return true;
 //   }

    protected void deleteItem(){
    }
    protected void updateItemFields(){

    }
    //==============================================================================================
 /*   public TextWatcher textChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mIsChangedItem=true;
            setOptionsMenuVisibility();
            Log.e("textChangedListener 1","afterTextChanged 1");
        }
    };
*/
}
