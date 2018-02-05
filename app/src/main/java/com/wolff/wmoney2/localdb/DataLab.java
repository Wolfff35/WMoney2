package com.wolff.wmoney2.localdb;

import android.content.Context;

import com.wolff.wmoney2.model.WBase;

import java.util.ArrayList;

/**
 * Created by wolfff on 01.02.18.
 */

public class DataLab<T extends WBase> {
    private static DataLab sDataLab;

    private Context mContext;

    private DataLab(Context context){
        mContext = context.getApplicationContext();
    }
    public static DataLab get(Context context){
        if(sDataLab==null){
            sDataLab = new DataLab(context);
        }
        return sDataLab;
    }
    public T fingById(double idCurr,ArrayList<T> itemList){

        for (T item:itemList) {
            if(item.getId()==idCurr){
                return item;
            }
        }
        return null;
    }

}
