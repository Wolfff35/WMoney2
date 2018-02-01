package com.wolff.wmoney2.model;

import java.io.Serializable;

/**
 * Created by wolff on 23.05.2017.
 */

public class WCategory extends WBase implements Serializable {
    private static final long serialVersionUID = 1363051468057804396L;
    private boolean mIsCredit;

    public WCategory(){
        //this.setDateCreation(new Date());
    }
    public boolean isCredit() {
        return mIsCredit;
    }

    public void setCredit(boolean credit) {
        mIsCredit = credit;
    }

}
