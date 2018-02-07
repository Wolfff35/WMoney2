package com.wolff.wmoney2.tools;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.wolff.wmoney2.R;
import com.wolff.wmoney2.localdb.DbSchema;
import com.wolff.wmoney2.tools.PreferencesTools;

/**
 * Created by wolff on 09.08.2017.
 */

public class UITools {
   /* public void designNavigationMenu(Context context, Menu menu){
        MenuItem nav_menu_item_documents = menu.findItem(R.id.nav_menu_item_documents);
        SpannableString s = new SpannableString(nav_menu_item_documents.getTitle());
        s.setSpan(new TextAppearanceSpan(context,R.style.nav_menu_item_documents),0,s.length(),0);
        nav_menu_item_documents.setTitle(s);

    }
    */
    public void firstRunInitialize(Context context){
        Log.e("FIRST RUN","INIT");
        new PreferencesTools().setBooleanPreference(context,PreferencesTools.PREFERENCE_IS_FIRST_RUN,false);
    }
    public void displayFragment4(FragmentActivity context, android.support.v4.app.Fragment fragment) {
        android.support.v4.app.FragmentTransaction fragmentTransaction;
        android.support.v4.app.FragmentManager fm = context.getSupportFragmentManager();

        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_main, fragment);
                //.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }
    public void displayFragment(FragmentActivity context, Fragment fragment,boolean addToBackStack) {
        FragmentTransaction fragmentTransaction;
        FragmentManager fm = context.getFragmentManager();

        fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_main, fragment);
        if(addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        //.addToBackStack(fragment.getTag());
        fragmentTransaction.commit();
    }
    public String getListTitle(String table_name){
        switch (table_name){
            case DbSchema.Table_Account.TABLE_NAME: {
                return "Счета";
                //break;
            }
            case DbSchema.Table_Category_Debit.TABLE_NAME: {
                return "Статьи дохода";
                //break;
            }
            case DbSchema.Table_Category_Credit.TABLE_NAME: {
                return "Статьи расхода";
                //break;
            }

            case DbSchema.Table_Currency.TABLE_NAME: {
                return "Валюты";
                //break;
            }

            case DbSchema.Table_Debit.TABLE_NAME: {
                return "Доходы";
                //break;
            }
            case DbSchema.Table_Credit.TABLE_NAME: {
                return "Расходы";
                //break;
            }
            case DbSchema.Table_Transfer.TABLE_NAME: {
                return "Переводы";
                //break;
            }
            default:
                return "НЕПОНЯТНО";
        }
    }
/*
   // Восстанавливаем уже созданный фрагмент
    FragmentManager fm = getSupportFragmentManager();
    fragment = (MyFragment) fm.findFragmentByTag(FRAGMENT_INSTANCE_NAME);
    // Если фрагмент не сохранен, создаем новый экземпляр
    if(fragment == null){
        fragment = new MyFragment();
        fm.beginTransaction().add(R.id.container, fragment, FRAGMENT_INSTANCE_NAME).commit();
 */
}
