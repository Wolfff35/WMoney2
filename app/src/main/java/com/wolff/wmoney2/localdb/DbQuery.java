package com.wolff.wmoney2.localdb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by wolfff on 23.01.18.
 */

public class DbQuery {
    private static DbQuery sDbQuery;
    private Context mContext;
    private String mTableName;


    private SQLiteDatabase mDatabase;

    private DbQuery(Context context,String tableName){
        mContext = context.getApplicationContext();
        mDatabase = new DbHelper(mContext).getReadableDatabase();
        mTableName = tableName;
    }
    public static DbQuery get(Context context,String tableName) {
        if (sDbQuery == null) {
            sDbQuery = new DbQuery(context,tableName);
        }
        return sDbQuery;
    }
    public DbCursorWrapper query(){
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = mDatabase.query(mTableName,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
        return new DbCursorWrapper(cursor);
    }

/*    public DbCursorWrapper queryWCurrency(){
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = mDatabase.query(DbSchema.Table_Currency.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
        return new DbCursorWrapper(cursor);
    }
    public DbCursorWrapper queryWAccount(){
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = mDatabase.query(DbSchema.Table_Account.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
        //Log.e("QUERY","=== QUERY");
        return new DbCursorWrapper(cursor);
    }
    public DbCursorWrapper queryWCategory(int isCredit) {
        //0 - all, 1 - credit,2 - debit
        String selection;
        String[] selectionArgs;
        String[] columns = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        if (isCredit == 0) {
            selection = null;
            selectionArgs = null;
            Log.e("SELECTION", "category = all");
        } else if (isCredit == 1) {
            selection = DbSchema.Table_Category.Cols.ISCREDIT + " = ?";
            selectionArgs = new String[]{"1"};
            Log.e("SELECTION", "category = CREDIT");
        } else if (isCredit == 2) {
            selection = DbSchema.Table_Category.Cols.ISCREDIT + " = ?";
            selectionArgs = new String[]{"0"};
            Log.e("SELECTION", "category = DEBIT");
        } else {
            selection = null;
            selectionArgs = null;
            Log.e("SELECTION", "category = all");
        }

        Cursor cursor = mDatabase.query(DbSchema.Table_Category.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
        return new DbCursorWrapper(cursor);
    }
    public DbCursorWrapper queryWOperation(int typeOperation){
        String selection=null;
        String[] selectionArgs = null;
        String[] columns = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String table = getOperationTableNameByType(typeOperation);
        Cursor cursor = mDatabase.query(table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
        return new DbCursorWrapper(cursor);
    }
    public String getOperationTableNameByType(int type){
        if(type==DbSchema.TYPE_OPERATION_CREDIT){
            return DbSchema.Table_Credit.TABLE_NAME;
        }else {
            return DbSchema.Table_Debit.TABLE_NAME;
        }
    }
    public DbCursorWrapper queryWTransfer(){
        String selection=null;
        String[] selectionArgs = null;
        String[] columns = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;
        String table = DbSchema.Table_Transfer.TABLE_NAME;
        Cursor cursor = mDatabase.query(table,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
        return new DbCursorWrapper(cursor);
    }

    */
}
