package com.wolff.wmoney2.localdb;

import android.content.Context;

import com.wolff.wmoney2.model.WAccount;
import com.wolff.wmoney2.model.WCategory;
import com.wolff.wmoney2.model.WCurrency;

import java.util.ArrayList;

/**
 * Created by wolfff on 01.02.18.
 */

public class DataLab {
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
    public WCurrency fingCurrencyById(double idCurr,ArrayList<WCurrency> currencyList){

        for (WCurrency item:currencyList) {
            if(item.getId()==idCurr){
                return item;
            }
        }
        return null;
    }
    public WAccount fingAccountById(double idAcc,ArrayList<WAccount>accountList){
        for (WAccount item:accountList) {
            if(item.getId()==idAcc){
                return item;
            }
        }
        return null;
    }
    public WCategory fingCategoryById(double idCategory, ArrayList<WCategory> categoryList){

        for (WCategory item:categoryList) {
            if(item.getId()==idCategory){
                return item;
            }
        }
        return null;
    }

}
