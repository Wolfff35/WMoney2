package com.wolff.wmoney2.localdb;

import android.content.ContentValues;
import android.content.Context;

import com.wolff.wmoney2.model.WAccount;
import com.wolff.wmoney2.model.WBase;
import com.wolff.wmoney2.model.WCategoryCredit;
import com.wolff.wmoney2.model.WCategoryDebit;
import com.wolff.wmoney2.model.WOperationCredit;
import com.wolff.wmoney2.model.WOperationDebit;
import com.wolff.wmoney2.model.WTransfer;
import com.wolff.wmoney2.tools.DateFormatTools;
import com.wolff.wmoney2.tools.DebugTools;

import java.util.Date;

/**
 * Created by wolfff on 23.01.18.
 */

public class DbContentValues<T extends WBase> {
    //private static DbContentValues sDbContentValues;
    private T mItem;

    public DbContentValues(T item){
        this.mItem=item;
        DebugTools.Log("DbContentValues",""+item.getClass().getSimpleName());
    }

    public ContentValues getContentValues(){
        ContentValues values = new ContentValues();
        switch (mItem.getClass().getSimpleName()){
            case "WCurrency": {
                 values= getWCurrency(mItem);
                break;
            }
            case "WAccount":{
                values = getWAccount(mItem);
                break;
            }
            case "WCategoryDebit": {
                values = getWCategoryDebit(mItem);
                break;
            }
            case "WCategoryCredit": {
                values = getWCategoryCredit(mItem);
                break;
            }
            case "WOperationDebit": {
                values = getWOperationDebit(mItem);
                break;
            }
            case "WOperationCredit": {
                values = getWOperationCredit(mItem);
                break;
            }
            case "WTransfer": {
                values = getWTransfer(mItem);
                break;
            }
            default:{

            }
        }
        return values;
    }
    private ContentValues getWCurrency(T currency){
        ContentValues values = new ContentValues();
        values.put(DbSchema.BaseColumns.NAME,currency.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,currency.getDescribe());
        if(currency.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(currency.getDateCreation(), DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    private ContentValues getWAccount(T account){
        ContentValues values = new ContentValues();
        WAccount a = (WAccount) account;
        values.put(DbSchema.BaseColumns.NAME,a.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,a.getDescribe());
        values.put(DbSchema.Table_Account.Cols.ID_CURRENCY,a.getCurrency().getId());
        values.put(DbSchema.Table_Account.Cols.ID_PICTURE,a.getIdPicture());
        values.put(DbSchema.Table_Account.Cols.SUMMA,a.getSumma());
        if(a.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(a.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    private ContentValues getWCategoryDebit(T category1){
        ContentValues values = new ContentValues();
        WCategoryDebit category = (WCategoryDebit) category1;
        values.put(DbSchema.BaseColumns.NAME,category.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,category.getDescribe());
        if(category.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(category.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    private ContentValues getWCategoryCredit(T category1){
        ContentValues values = new ContentValues();
        WCategoryCredit category = (WCategoryCredit) category1;
        values.put(DbSchema.BaseColumns.NAME,category.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,category.getDescribe());
        if(category.getDateCreation()==null) {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(new Date(),DateFormatTools.DATE_FORMAT_SAVE));
        }else {
            values.put(DbSchema.BaseColumns.DATE_CREATION, new DateFormatTools().dateToString(category.getDateCreation(),DateFormatTools.DATE_FORMAT_SAVE));
        }
        return values;
    }
    private ContentValues getWOperationDebit(T credit1){
        DateFormatTools dateUtils = new DateFormatTools();
        ContentValues values = new ContentValues();
        WOperationDebit credit = (WOperationDebit) credit1;
        values.put(DbSchema.BaseColumns.NAME,credit.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,credit.getDescribe());
        WAccount lAccount = credit.getAccount();
        if(lAccount!=null) {
            values.put(DbSchema.Table_OperDebCred.Cols.ID_ACCOUNT, lAccount.getId());
        }
        WCategoryDebit lCategory = credit.getCategory();
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
    private ContentValues getWOperationCredit(T credit1){
        DateFormatTools dateUtils = new DateFormatTools();
        ContentValues values = new ContentValues();
        WOperationCredit credit = (WOperationCredit) credit1;
        values.put(DbSchema.BaseColumns.NAME,credit.getName());
        values.put(DbSchema.BaseColumns.DESCRIBE,credit.getDescribe());
        WAccount lAccount = credit.getAccount();
        if(lAccount!=null) {
            values.put(DbSchema.Table_OperDebCred.Cols.ID_ACCOUNT, lAccount.getId());
        }
        WCategoryCredit lCategory = credit.getCategory();
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
    private ContentValues getWTransfer(T transfer1){
        DateFormatTools dateUtils = new DateFormatTools();
        ContentValues values = new ContentValues();
        WTransfer transfer = (WTransfer) transfer1;
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

}
