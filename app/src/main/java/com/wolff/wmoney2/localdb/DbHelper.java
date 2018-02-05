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
        db.execSQL(DbSchema.CREATE_ACCOUNTS_TABLE);
        db.execSQL(DbSchema.CREATE_CATEGORY_DEBIT_TABLE);
        db.execSQL(DbSchema.CREATE_CATEGORY_CREDIT_TABLE);
        db.execSQL(DbSchema.CREATE_CREDIT_TABLE);
        db.execSQL(DbSchema.CREATE_CURRENCY_TABLE);
        db.execSQL(DbSchema.CREATE_DEBIT_TABLE);
        db.execSQL(DbSchema.CREATE_TRANSFER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
