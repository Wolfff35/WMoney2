package com.wolff.wmoney2.localdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.wolff.wmoney2.model.WAccount;
import com.wolff.wmoney2.model.WCategory;
import com.wolff.wmoney2.model.WCurrency;
import com.wolff.wmoney2.model.WOperation;
import com.wolff.wmoney2.model.WTransfer;


/**
 * Created by wolfff on 22.01.18.
 */

public class DbSetData {
    private static DbSetData sDbSetData;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private DbSetData(Context context){
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
public void currency_add(WCurrency currency){
    ContentValues values = DbContentValues.get().getContentValues_WCurrency(currency);
    mDatabase.insert(DbSchema.Table_Currency.TABLE_NAME,null,values);
    Log.e("add currency","Success");
}
    public void currency_update(WCurrency currency){
        ContentValues values = DbContentValues.get().getContentValues_WCurrency(currency);
        mDatabase.update(
                DbSchema.Table_Currency.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID+" = ?",
                new String[]{String.valueOf(currency.getId())}
        );
        Log.e("update currency"," Success");
    }
    public void currency_delete(WCurrency currency){
        mDatabase.delete(
                DbSchema.Table_Currency.TABLE_NAME,
                DbSchema.BaseColumns.ID+" =?",
                new String[]{String.valueOf(currency.getId())}
        );
        Log.e("delete currency","Success");
    }

    public void account_add(WAccount account){
        ContentValues values = DbContentValues.get().getContentValues_WAccount(account);
        mDatabase.insert(DbSchema.Table_Account.TABLE_NAME,null,values);
        Log.e("add account","Success");
    }
    public void account_update(WAccount account){
        ContentValues values = DbContentValues.get().getContentValues_WAccount(account);
        mDatabase.update(
                DbSchema.Table_Account.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID+" = ?",
                new String[]{String.valueOf(account.getId())}
        );
        Log.e("update account"," Success");
    }
    public void account_delete(WAccount account){
        mDatabase.delete(
                DbSchema.Table_Account.TABLE_NAME,
                DbSchema.BaseColumns.ID+" =?",
                new String[]{String.valueOf(account.getId())}
        );
        Log.e("delete account","Success");
    }
    public void category_add(WCategory category){
        ContentValues values = DbContentValues.get().getContentValues_WCategory(category);
        mDatabase.insert(DbSchema.Table_Category.TABLE_NAME,null,values);
        Log.e("add category","Success");
    }
    public void category_update(WCategory category){
        ContentValues values = DbContentValues.get().getContentValues_WCategory(category);
        mDatabase.update(
                DbSchema.Table_Category.TABLE_NAME,
                values,
                DbSchema.BaseColumns.ID+" = ?",
                new String[]{String.valueOf(category.getId())}
        );
        Log.e("update category"," Success");
    }
    public void category_delete(WCategory category){
        mDatabase.delete(
                DbSchema.Table_Category.TABLE_NAME,
                DbSchema.BaseColumns.ID+" =?",
                new String[]{String.valueOf(category.getId())}
        );
        Log.e("delete category","Success");
    }
    public void operation_add(WOperation oper, int typeOperation){
        ContentValues values = DbContentValues.get().getContentValues_WOperation(oper);
        String table = DbQuery.get(mContext).getOperationTableNameByType(typeOperation);
        mDatabase.insert(table,null,values);
        Log.e("add oper","Success");
    }
     public void operation_update(WOperation oper,int typeOperation){
        ContentValues values = DbContentValues.get().getContentValues_WOperation(oper);
        String table = DbQuery.get(mContext).getOperationTableNameByType(typeOperation);
        mDatabase.update(
                table,
                values,
                DbSchema.BaseColumns.ID+" = ?",
                new String[]{String.valueOf(oper.getId())}
        );
        Log.e("update oper"," Success");
    }
    public void operation_delete(WOperation oper, int typeOperation){
        String table = DbQuery.get(mContext).getOperationTableNameByType(typeOperation);
        mDatabase.delete(
                table,
                DbSchema.BaseColumns.ID+" =?",
                new String[]{String.valueOf(oper.getId())}
        );
        Log.e("delete oper","Success");
    }

    public void transfer_add(WTransfer transfer){
        ContentValues values = DbContentValues.get().getContentValues_WTransfer(transfer);
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        mDatabase.insert(table,null,values);
        Log.e("add transfer","Success");
    }
    public void transfer_update(WTransfer transfer){
        ContentValues values = DbContentValues.get().getContentValues_WTransfer(transfer);
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        mDatabase.update(
                table,
                values,
                DbSchema.BaseColumns.ID+" = ?",
                new String[]{String.valueOf(transfer.getId())}
        );
        Log.e("update transfer"," Success");
    }
    public void transfer_delete(WTransfer transfer){
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        mDatabase.delete(
                table,
                DbSchema.BaseColumns.ID+" =?",
                new String[]{String.valueOf(transfer.getId())}
        );
        Log.e("delete transfer","Success");
    }


    /*    public void testObject_add(WTestObject testObject){
        ContentValues cv = DbContentValues.getCV_testObject(testObject);
        mDatabase.insert(DbSchema.Table_Test.TABLE_NAME,null,cv);
    }
    public void testObject_delete(WTestObject testObject) {
        mDatabase.delete(
                DbSchema.Table_Test.TABLE_NAME,
                DbSchema.Table_Test.Cols.ID + " =?",
                new String[]{String.valueOf(testObject.get_id())}
        );
    }
*/
}
