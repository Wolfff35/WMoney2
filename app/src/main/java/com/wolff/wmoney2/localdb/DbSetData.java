package com.wolff.wmoney2.localdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wolff.wmoney2.model.WAccount;
import com.wolff.wmoney2.model.WCategoryCredit;
import com.wolff.wmoney2.model.WCategoryDebit;
import com.wolff.wmoney2.model.WCurrency;
import com.wolff.wmoney2.model.WOperationCredit;
import com.wolff.wmoney2.model.WOperationDebit;
import com.wolff.wmoney2.model.WTransfer;


/**
 * Created by wolfff on 22.01.18.
 */

public class DbSetData {
    private static DbSetData sDbSetData;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private DbSetData(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DbHelper(mContext).getWritableDatabase();
    }

    public static DbSetData get(Context context) {
        if (sDbSetData == null) {
            sDbSetData = new DbSetData(context);
        }
        return sDbSetData;
    }

    //-----------------------------------------------------
    public void currency_add(WCurrency currency) {
        ContentValues values = new DbContentValues(currency).getContentValues();
        mDatabase.insert(DbSchema.Table_Currency.TABLE_NAME, null, values);
        Log.e("add currency", "Success");
    }

    public void currency_update(WCurrency currency) {
        ContentValues values = new DbContentValues(currency).getContentValues();
        mDatabase.update(
                DbSchema.Table_Currency.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(currency.getId())}
        );
        Log.e("update currency", " Success");
    }

    public void currency_delete(WCurrency currency) {
        mDatabase.delete(
                DbSchema.Table_Currency.TABLE_NAME,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(currency.getId())}
        );
        Log.e("delete currency", "Success");
    }
//--------------------------------------------------------------------------------------------------
    public void account_add(WAccount account) {
        ContentValues values = new DbContentValues(account).getContentValues();
        mDatabase.insert(DbSchema.Table_Account.TABLE_NAME, null, values);
        Log.e("add account", "Success");
    }

    public void account_update(WAccount account) {
        ContentValues values = new DbContentValues(account).getContentValues();
        mDatabase.update(
                DbSchema.Table_Account.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(account.getId())}
        );
        Log.e("update account", " Success");
    }

    public void account_delete(WAccount account) {
        mDatabase.delete(
                DbSchema.Table_Account.TABLE_NAME,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(account.getId())}
        );
        Log.e("delete account", "Success");
    }
//--------------------------------------------------------------------------------------------------
    public void category_debit_add(WCategoryDebit category) {
        ContentValues values = new DbContentValues(category).getContentValues();
        mDatabase.insert(DbSchema.Table_Category_Debit.TABLE_NAME, null, values);
        Log.e("add category", "Success");
    }

    public void category_debit_update(WCategoryDebit category) {
        ContentValues values = new DbContentValues(category).getContentValues();
        mDatabase.update(
                DbSchema.Table_Category_Debit.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(category.getId())}
        );
        Log.e("update category", " Success");
    }

    public void category_debit_delete(WCategoryDebit category) {
        mDatabase.delete(
                DbSchema.Table_Category_Debit.TABLE_NAME,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(category.getId())}
        );
        Log.e("delete category", "Success");
    }
    //--------------------------------------------------------------------------------------------------
    public void category_credit_add(WCategoryCredit category) {
        ContentValues values = new DbContentValues(category).getContentValues();
        mDatabase.insert(DbSchema.Table_Category_Credit.TABLE_NAME, null, values);
        Log.e("add category", "Success");
    }

    public void category_credit_update(WCategoryCredit category) {
        ContentValues values = new DbContentValues(category).getContentValues();
        mDatabase.update(
                DbSchema.Table_Category_Credit.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(category.getId())}
        );
        Log.e("update category", " Success");
    }

    public void category_credit_delete(WCategoryCredit category) {
        mDatabase.delete(
                DbSchema.Table_Category_Credit.TABLE_NAME,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(category.getId())}
        );
        Log.e("delete category", "Success");
    }
//--------------------------------------------------------------------------------------------------
    public void operation_debit_add(WOperationDebit oper) {
        ContentValues values = new DbContentValues(oper).getContentValues();
        mDatabase.insert(DbSchema.Table_Debit.TABLE_NAME, null, values);
        Log.e("add oper", "Success");
    }

    public void operation_debit_update(WOperationDebit oper) {
        ContentValues values = new DbContentValues(oper).getContentValues();
        mDatabase.update(
                DbSchema.Table_Debit.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(oper.getId())}
        );
        Log.e("update oper", " Success");
    }

    public void operation_debit_delete(WOperationDebit oper) {
        mDatabase.delete(
                DbSchema.Table_Debit.TABLE_NAME,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(oper.getId())}
        );
        Log.e("delete oper", "Success");
    }
    //--------------------------------------------------------------------------------------------------
    public void operation_credit_add(WOperationCredit oper) {
        ContentValues values = new DbContentValues(oper).getContentValues();
        mDatabase.insert(DbSchema.Table_Credit.TABLE_NAME, null, values);
        Log.e("add oper", "Success");
    }

    public void operation_credit_update(WOperationCredit oper, int typeOperation) {
        ContentValues values = new DbContentValues(oper).getContentValues();
        mDatabase.update(
                DbSchema.Table_Credit.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(oper.getId())}
        );
        Log.e("update oper", " Success");
    }

    public void operation_credit_delete(WOperationCredit oper) {
        mDatabase.delete(
                DbSchema.Table_Credit.TABLE_NAME,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(oper.getId())}
        );
        Log.e("delete oper", "Success");
    }
//--------------------------------------------------------------------------------------------------
    public void transfer_add(WTransfer transfer) {
        ContentValues values = new DbContentValues(transfer).getContentValues();
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        mDatabase.insert(table, null, values);
        Log.e("add transfer", "Success");
    }

    public void transfer_update(WTransfer transfer) {
        ContentValues values = new DbContentValues(transfer).getContentValues();
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        mDatabase.update(
                table,
                values,
                DbSchema.BaseColumns.ID + " = ?",
                new String[]{String.valueOf(transfer.getId())}
        );
        Log.e("update transfer", " Success");
    }

    public void transfer_delete(WTransfer transfer) {
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        mDatabase.delete(
                table,
                DbSchema.BaseColumns.ID + " =?",
                new String[]{String.valueOf(transfer.getId())}
        );
        Log.e("delete transfer", "Success");
    }

}
