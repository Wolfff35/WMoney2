package com.wolff.wmoney2.localdb;

import android.content.ContentValues;
import android.content.Context;

import com.wolff.wmoney2.model.WAccount;
import com.wolff.wmoney2.model.WCategory;
import com.wolff.wmoney2.model.WCurrency;
import com.wolff.wmoney2.model.WOperation;
import com.wolff.wmoney2.model.WTransfer;
import com.wolff.wmoney2.tools.DateFormatTools;

import java.util.Date;

/**
 * Created by wolfff on 23.01.18.
 */

public class DbContentValues {
    private static DbContentValues sDbContentValues;

    private DbContentValues(){
    }
    public static DbContentValues get(){
        if(sDbContentValues==null){
            sDbContentValues = new DbContentValues();
        }
        return sDbContentValues;
    }

    public static ContentValues getContentValues_WCurrency(WCurrency currency){
        ContentValues values = new ContentValues();
        //values.put(DbSchema.BaseColumns.ID,currency.getId());
        values.put(DbSchema.BaseColumns.NAME,currency.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,currency.getDescribe());
        if(currency.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(currency.getDateCreation(), DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    public static ContentValues getContentValues_WAccount(WAccount account){
        ContentValues values = new ContentValues();
        //values.put(DbSchema.BaseColumns.ID,currency.getId());
        values.put(DbSchema.BaseColumns.NAME,account.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,account.getDescribe());
        values.put(DbSchema.Table_Account.Cols.ID_CURRENCY,account.getCurrency().getId());
        values.put(DbSchema.Table_Account.Cols.ID_PICTURE,account.getIdPicture());
        values.put(DbSchema.Table_Account.Cols.SUMMA,account.getSumma());
        if(account.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(account.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    public static ContentValues getContentValues_WCategory(WCategory category){
        ContentValues values = new ContentValues();
        values.put(DbSchema.BaseColumns.NAME,category.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,category.getDescribe());
        values.put(DbSchema.Table_Category.Cols.ISCREDIT,((category.isCredit()?1:0)));
        if(category.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(category.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    public static ContentValues getContentValues_WOperation(WOperation credit){
        DateFormatTools dateUtils = new DateFormatTools();
        ContentValues values = new ContentValues();
        values.put(DbSchema.BaseColumns.NAME,credit.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,credit.getDescribe());
        WAccount lAccount = credit.getAccount();
        if(lAccount!=null) {
            values.put(DbSchema.Table_OperDebCred.Cols.ID_ACCOUNT, lAccount.getId());
            //WCurrency lCurrency = credit.getAccount().getCurrency();
            //if(lCurrency!=null) {
            //    values.put(DbSchema.Table_OperDebCred.Cols.ID_CURRENCY, lCurrency.getId());
            //}
        }
        WCategory lCategory = credit.getCategory();
        if(lCategory!=null) {
            values.put(DbSchema.Table_OperDebCred.Cols.ID_CATEGORY, lCategory.getId());
        }
        values.put(DbSchema.Table_OperDebCred.Cols.SUMMA,credit.getSumma());
        values.put(DbSchema.Table_OperDebCred.Cols.DATE_OPER,dateUtils.dateToString(credit.getDateOper(),DateFormatTools.DATE_FORMAT_SAVE));

        if(credit.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION,dateUtils.dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION,dateUtils.dateToString(credit.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    public static ContentValues getContentValues_WTransfer(WTransfer transfer){
        DateFormatTools dateUtils = new DateFormatTools();
        ContentValues values = new ContentValues();
        values.put(DbSchema.BaseColumns.NAME,transfer.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,transfer.getDescribe());
        WAccount lAccountFrom = transfer.getAccountFrom();
        if(lAccountFrom!=null) {
            values.put(DbSchema.Table_Transfer.Cols.ID_ACCOUNT_FROM, lAccountFrom.getId());
        }
        WAccount lAccountTo = transfer.getAccountTo();
        if(lAccountTo!=null) {
            values.put(DbSchema.Table_Transfer.Cols.ID_ACCOUNT_TO, lAccountTo.getId());
        }
        values.put(DbSchema.Table_Transfer.Cols.SUMMA_FROM,transfer.getSummaFrom());
        values.put(DbSchema.Table_Transfer.Cols.SUMMA_TO,transfer.getSummaTo());
        values.put(DbSchema.Table_Transfer.Cols.DATE_OPER,dateUtils.dateToString(transfer.getDateOper(),DateFormatTools.DATE_FORMAT_SAVE));

        if(transfer.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION,dateUtils.dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION,dateUtils.dateToString(transfer.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }

    /*
    public static ContentValues getCV_testObject(WTestObject testObject){
        ContentValues values = new ContentValues();
        values.put(DbSchema.Table_Test.Cols.ID,testObject.get_id());
        values.put(DbSchema.Table_Test.Cols.DATE,testObject.get_id());
        values.put(DbSchema.Table_Test.Cols.COORD,testObject.get_id());
        return values;
    }
    */
}
