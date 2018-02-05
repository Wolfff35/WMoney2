package com.wolff.wmoney2.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wolff on 01.06.2017.
 */

public class WOperationCredit extends WBase implements Serializable {
    private static final long serialVersionUID = 1253051678907804396L;
    private WAccount mAccount;
    private WCategoryCredit mCategory;
    private double mSumma;
    private Date mDateOper;

    public WAccount getAccount() {
        return mAccount;
    }

    public void setAccount(WAccount account) {
        mAccount = account;
    }

    public WCategoryCredit getCategory() {
        return mCategory;
    }

    public void setCategory(WCategoryCredit category) {
        mCategory = category;
    }

    public double getSumma() {
        return mSumma;
    }

    public void setSumma(double summa) {
        mSumma = summa;
    }

     public Date getDateOper() {
        return mDateOper;
    }

    public void setDateOper(Date dateOper) {
        mDateOper = dateOper;
    }
}
