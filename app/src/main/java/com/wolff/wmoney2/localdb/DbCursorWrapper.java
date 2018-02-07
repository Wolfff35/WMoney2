package com.wolff.wmoney2.localdb;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;

import com.wolff.wmoney2.model.WAccount;
import com.wolff.wmoney2.model.WBase;
import com.wolff.wmoney2.model.WCategoryCredit;
import com.wolff.wmoney2.model.WCategoryDebit;
import com.wolff.wmoney2.model.WCurrency;
import com.wolff.wmoney2.model.WOperationCredit;
import com.wolff.wmoney2.model.WOperationDebit;
import com.wolff.wmoney2.model.WTransfer;
import com.wolff.wmoney2.tools.DateFormatTools;
import com.wolff.wmoney2.tools.DebugTools;

import java.util.ArrayList;

/**
 * Created by wolfff on 22.01.18.
 */

public class DbCursorWrapper<T extends WBase> extends CursorWrapper {
        private T mItem;
        private Context mContext;
      public DbCursorWrapper(Cursor cursor,Context context) {
        super(cursor);
        mContext=context;
    }
    public T get(String table_name){
        switch (table_name){
            case DbSchema.Table_Currency.TABLE_NAME: {
                mItem= getWCurrency();
                break;
            }
            case DbSchema.Table_Account.TABLE_NAME:{
                mItem = getWAccount();
                break;
            }
            case DbSchema.Table_Category_Debit.TABLE_NAME: {
                mItem = getWCategoryDebit();
                break;
            }
            case DbSchema.Table_Category_Credit.TABLE_NAME: {
                mItem = getWCategoryCredit();
                break;
            }
            case DbSchema.Table_Debit.TABLE_NAME: {
                mItem = getWOperationDebit();
                break;
            }
            case DbSchema.Table_Credit.TABLE_NAME: {
                mItem = getWOperationCredit();
                break;
            }
            case DbSchema.Table_Transfer.TABLE_NAME: {
                mItem = getWTransfer();
                break;
            }
            default:{

            }
        }
        return mItem;
    }

    public T getWCurrency(){
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));
        WCurrency currency = new WCurrency();
        currency.setId(s_id);
        currency.setName(s_name);
        currency.setDescribe(s_describe);
        currency.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)),DateFormatTools.DATE_FORMAT_SAVE));
        return (T)currency;
    }
    public T getWCategoryDebit() {
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));
        WCategoryDebit category = new WCategoryDebit();
        category.setId(s_id);
        category.setName(s_name);
        category.setDescribe(s_describe);
        category.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)), DateFormatTools.DATE_FORMAT_SAVE));
        return (T) category;
    }
    public T getWCategoryCredit() {
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));
        WCategoryCredit category = new WCategoryCredit();
        category.setId(s_id);
        category.setName(s_name);
        category.setDescribe(s_describe);
        category.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)), DateFormatTools.DATE_FORMAT_SAVE));
        return (T) category;
    }
    public T getWAccount(){
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));

        int id_pict = getInt(getColumnIndex(DbSchema.Table_Account.Cols.ID_PICTURE));
        int id_curr = getInt(getColumnIndex(DbSchema.Table_Account.Cols.ID_CURRENCY));
        double sum = getDouble(getColumnIndex(DbSchema.Table_Account.Cols.SUMMA));
        WAccount account = new WAccount();
        account.setId(s_id);
        account.setName(s_name);
        account.setDescribe(s_describe);
        account.setIdPicture(id_pict);
        account.setSumma(sum);
        account.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)),DateFormatTools.DATE_FORMAT_SAVE));
        DataLab dataLab = DataLab.get(mContext);
        account.setCurrency((WCurrency) dataLab.fingById(id_curr,new DbGetData<WCurrency>(mContext).getList(DbSchema.Table_Currency.TABLE_NAME)));
        return (T) account;
    }
    public T getWOperationDebit(){
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));

        int id_acc = getInt(getColumnIndex(DbSchema.Table_OperDebCred.Cols.ID_ACCOUNT));
        int id_cat = getInt(getColumnIndex(DbSchema.Table_OperDebCred.Cols.ID_CATEGORY));
        double sum = getDouble(getColumnIndex(DbSchema.Table_OperDebCred.Cols.SUMMA));
        String datOperS = getString(getColumnIndex(DbSchema.Table_OperDebCred.Cols.DATE_OPER));
        WOperationDebit credit = new WOperationDebit();
        credit.setId(s_id);
        credit.setName(s_name);
        credit.setDescribe(s_describe);
        credit.setSumma(sum);
        DateFormatTools dateUtils = new DateFormatTools();
        credit.setDateOper(dateUtils.dateFromString(datOperS,DateFormatTools.DATE_FORMAT_SAVE));
        credit.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)),DateFormatTools.DATE_FORMAT_SAVE));
        DataLab dataLab = DataLab.get(mContext);
        ArrayList<WAccount> acc = new DbGetData<WAccount>(mContext).getList(DbSchema.Table_Account.TABLE_NAME);
        credit.setAccount((WAccount) dataLab.fingById(id_acc,acc));
        credit.setCategory((WCategoryDebit) dataLab.fingById(id_cat,new DbGetData<WCategoryDebit>(mContext).getList(DbSchema.Table_Category_Debit.TABLE_NAME)));
        DebugTools.Log("getWOperationDebit","item - "+credit.getName());
        return (T) credit;
    }
    public T getWOperationCredit(){
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));

        int id_acc = getInt(getColumnIndex(DbSchema.Table_OperDebCred.Cols.ID_ACCOUNT));
        int id_cat = getInt(getColumnIndex(DbSchema.Table_OperDebCred.Cols.ID_CATEGORY));
        double sum = getDouble(getColumnIndex(DbSchema.Table_OperDebCred.Cols.SUMMA));
        String datOperS = getString(getColumnIndex(DbSchema.Table_OperDebCred.Cols.DATE_OPER));
        WOperationCredit credit = new WOperationCredit();
        credit.setId(s_id);
        credit.setName(s_name);
        credit.setDescribe(s_describe);
        credit.setSumma(sum);
        DateFormatTools dateUtils = new DateFormatTools();
        credit.setDateOper(dateUtils.dateFromString(datOperS,DateFormatTools.DATE_FORMAT_SAVE));
        credit.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)),DateFormatTools.DATE_FORMAT_SAVE));
        DataLab dataLab = DataLab.get(mContext);
        credit.setAccount((WAccount) dataLab.fingById(id_acc,new DbGetData<WAccount>(mContext).getList(DbSchema.Table_Account.TABLE_NAME)));
        credit.setCategory((WCategoryCredit) dataLab.fingById(id_cat,new DbGetData<WCategoryCredit>(mContext).getList(DbSchema.Table_Category_Credit.TABLE_NAME)));
        return (T) credit;
    }
    public T getWTransfer(){
        int s_id = getInt(getColumnIndex(DbSchema.BaseColumns.ID));
        String s_name = getString(getColumnIndex(DbSchema.BaseColumns.NAME));
        String s_describe = getString(getColumnIndex(DbSchema.BaseColumns.DESCRIBE));

        int id_accFrom = getInt(getColumnIndex(DbSchema.Table_Transfer.Cols.ID_ACCOUNT_FROM));
        int id_accTo = getInt(getColumnIndex(DbSchema.Table_Transfer.Cols.ID_ACCOUNT_TO));
        double sum_from = getDouble(getColumnIndex(DbSchema.Table_Transfer.Cols.SUMMA_FROM));
        double sum_to = getDouble(getColumnIndex(DbSchema.Table_Transfer.Cols.SUMMA_TO));
        String datOperS = getString(getColumnIndex(DbSchema.Table_Transfer.Cols.DATE_OPER));
        WTransfer transfer = new WTransfer();
        transfer.setId(s_id);
        transfer.setName(s_name);
        transfer.setDescribe(s_describe);
        transfer.setSummaFrom(sum_from);
        transfer.setSummaTo(sum_to);
        DateFormatTools dateUtils = new DateFormatTools();
        transfer.setDateOper(dateUtils.dateFromString(datOperS,DateFormatTools.DATE_FORMAT_SAVE));
        transfer.setDateCreation(new DateFormatTools().dateFromString(getString(getColumnIndex(DbSchema.BaseColumns.DATE_CREATION)),DateFormatTools.DATE_FORMAT_SAVE));
        DataLab dataLab = DataLab.get(mContext);
        transfer.setAccountFrom((WAccount) dataLab.fingById(id_accFrom,new DbGetData<WAccount>(mContext).getList(DbSchema.Table_Account.TABLE_NAME)));
        transfer.setAccountTo((WAccount) dataLab.fingById(id_accTo,new DbGetData<WAccount>(mContext).getList(DbSchema.Table_Account.TABLE_NAME)));
        return (T) transfer;
    }
}
