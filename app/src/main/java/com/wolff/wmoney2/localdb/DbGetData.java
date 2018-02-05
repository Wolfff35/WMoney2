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

    public ArrayList<T> getList() {
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext, DbSchema.Table_Currency.TABLE_NAME).query();
        ArrayList<T> list = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            //currencyList.add(cursorWrapper.getWCurrency());
            list.add((T) cursorWrapper.get());
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return list;
    }

    /*
    public ArrayList<WCurrency> getWCurrencyList(){
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext).queryWCurrency();
        ArrayList<WCurrency> currencyList = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            currencyList.add(cursorWrapper.getWCurrency());
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return currencyList;
    }
    public ArrayList<WAccount> getWAccountList(Context context){
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext).queryWAccount();
        ArrayList<WAccount>accountList = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            accountList.add(cursorWrapper.getWAccount(context));
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return accountList;
    }
    public ArrayList<WCategory> getWCategoryList(int isCredit){
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext).queryWCategory(isCredit);
        ArrayList<WCategory> categoryList = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            categoryList.add(cursorWrapper.getWCategory(isCredit));
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return categoryList;
    }
    public ArrayList<WOperation> getWOperationList(Context context, int typeOperation){
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext).queryWOperation(typeOperation);
        ArrayList<WOperation> creditList = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            creditList.add(cursorWrapper.getWOperation(context));
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return creditList;
    }
    public ArrayList<WTransfer> getWTransferList(Context context){
        DbCursorWrapper cursorWrapper = DbQuery.get(mContext).queryWTransfer();
        ArrayList<WTransfer> transferList = new ArrayList<>();
        cursorWrapper.moveToFirst();
        while (!cursorWrapper.isAfterLast()) {
            transferList.add(cursorWrapper.getWTransfer(context));
            cursorWrapper.moveToNext();
        }
        cursorWrapper.close();
        return transferList;
    }
*/
 }
