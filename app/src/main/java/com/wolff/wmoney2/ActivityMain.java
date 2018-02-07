package com.wolff.wmoney2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wolff.wmoney2.fragments.List_items_fragment;
import com.wolff.wmoney2.fragments.MainMenu_fragment;
import com.wolff.wmoney2.localdb.DbSchema;
import com.wolff.wmoney2.tools.DebugTools;
import com.wolff.wmoney2.tools.Test_data;
import com.wolff.wmoney2.tools.UITools;

public class ActivityMain extends AppCompatActivity implements MainMenu_fragment.MainMenu_fragment_listener,List_items_fragment.List_items_fragment_listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new Test_data().fillTestData(getApplicationContext());
        new UITools().displayFragment(this,MainMenu_fragment.newInstance(),false);

     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMainMenuItemClick(int index) {
        DebugTools.Log("CLICK","index = "+index);
        //Intent intent = null;
        switch (index){
            case 0:{
                 new UITools().displayFragment(this,List_items_fragment.newInstance(DbSchema.Table_Debit.TABLE_NAME),true);
                break;
            }
            case 1:{
                new UITools().displayFragment(this,List_items_fragment.newInstance(DbSchema.Table_Credit.TABLE_NAME),true);
                break;
            }
            case 2:{
                new UITools().displayFragment(this,List_items_fragment.newInstance(DbSchema.Table_Transfer.TABLE_NAME),true);
                break;
            }
            case 3:{
                break;
            }

        }
    }

    @Override
    public void onItemClick(int item_position) {
        DebugTools.Log("onItemClick",""+item_position);
    }
}
