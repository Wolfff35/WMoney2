package com.wolff.wmoney2.localdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wolfff on 22.01.18.
 */

class DbHelper extends SQLiteOpenHelper {
    private  static final int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DbSchema.DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL(DbSchema.CREATE_TABLE_TEST);
        db.execSQL(DbSchema.CREATE_ACCOUNTS_TABLE);
        db.execSQL(DbSchema.CREATE_CATEGORY_TABLE);
        db.execSQL(DbSchema.CREATE_CREDIT_TABLE);
        db.execSQL(DbSchema.CREATE_CURRENCY_TABLE);
        db.execSQL(DbSchema.CREATE_DEBIT_TABLE);
        db.execSQL(DbSchema.CREATE_TRANSFER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS "+DbSchema.Table_Test.TABLE_NAME);
        //db.execSQL(DbSchema.CREATE_TABLE_TEST);
    }
}
