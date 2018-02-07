package com.wolff.wmoney2.localdb;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by wolfff on 23.01.18.
 */

public class DbGetData<T> {
    private Context mContext;
    public DbGetData(Context context){
        mContext = context.getApplicationContext();
    }

    public ArrayList<T> getList(String table_name) {
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext).query(table_name);
        ArrayList<T> list = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            list.add((T) cursorWrapper.get(table_name));
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return list;
    }

 }
