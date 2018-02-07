package com.wolff.wmoney2.tools;

import android.content.Context;

import com.wolff.wmoney2.localdb.DbSetData;
import com.wolff.wmoney2.model.WOperationCredit;
import com.wolff.wmoney2.model.WOperationDebit;

import java.util.Date;
import java.util.Random;
import java.util.RandomAccess;


/**
 * Created by wolff on 23.05.2017.
 */

public class Test_data {
    public void fillTestData(Context context){
/*        WOperationDebit oper = new WOperationDebit();
        oper.setSumma(new Random().nextDouble());
        oper.setDateOper(new Date());
        oper.setName("name operation "+ new Random().nextInt());
        oper.setDescribe("Desccccc");
        oper.setDateCreation(new Date());

        DbSetData.get(context).operation_debit_add(oper);
*/
        WOperationCredit oper = new WOperationCredit();
        oper.setSumma(new Random().nextDouble());
        oper.setDateOper(new Date());
        oper.setName("CREDIT operation "+ new Random().nextInt());
        oper.setDescribe("CREDIT jhjj Desccccc");
        oper.setDateCreation(new Date());

        DbSetData.get(context).operation_credit_add(oper);
   /*     DataLab dataLab = DataLab.get(context);
        WOperation credit1 = new WOperation();
        credit1.setName("Доход 1");
        credit1.setCategory(dataLab.fingCategoryById(1,dataLab.getWCategoryList(0)));
        //credit1.setCurrency(dataLab.fingCurrencyById(1,dataLab.getWCurrencyList()));
        credit1.setSumma(1);
        credit1.setAccount(dataLab.fingAccountById(1,dataLab.getWAccountList(context)));
        credit1.setDateOper(new Date());
        //credit1.setSummaVal(1000);
        credit1.setDateCreation(new Date());
        dataLab.operation_add(credit1, DbSchema.TYPE_OPERATION_DEBIT);
*/
        /*     WOperation credit1 = new WOperation();
        credit1.setName("расход 1");
        credit1.setCategory(dataLab.fingCategoryById(1,dataLab.getWCategoryList(0)));
        //credit1.setCurrency(dataLab.fingCurrencyById(1,dataLab.getWCurrencyList()));
        credit1.setSumma(1000);
        credit1.setAccount(dataLab.fingAccountById(1,dataLab.getWAccountList(context)));
        credit1.setDateOper(new Date());
        //credit1.setSummaVal(1000);
        credit1.setDateCreation(new Date());
        dataLab.operation_add(credit1, DbSchema.TYPE_OPERATION_CREDIT);

        WOperation credit2 = new WOperation();
        credit2.setName("расход 2");
        credit2.setCategory(dataLab.fingCategoryById(1,dataLab.getWCategoryList(0)));
       // credit2.setCurrency(dataLab.fingCurrencyById(1,dataLab.getWCurrencyList()));
        credit2.setSumma(567);
        credit2.setAccount(dataLab.fingAccountById(1,dataLab.getWAccountList(context)));
        credit2.setDateOper(new Date());
        //credit2.setSummaVal(8985);
        credit2.setDateCreation(new Date());
        dataLab.operation_add(credit2,DbSchema.TYPE_OPERATION_CREDIT);

            WCurrency curr = new WCurrency();
        curr.setName("UAH");
        curr.setDescribe("Гривна");
        dataLab.currency_add(curr);
        WCurrency curr2 = new WCurrency();
        curr2.setName("USD");
        curr2.setDescribe("Доллар");
        dataLab.currency_add(curr2);

        WAccount acc1 = new WAccount();
        acc1.setIdPicture(R.drawable.pict_account_1);
        acc1.setSumma(12345);
        acc1.setCurrency(dataLab.fingCurrencyById(1,DataLab.get(context).getWCurrencyList()));
        acc1.setName("Кошелек 1");
        acc1.setDescribe("Карман");
        acc1.setDateCreation(new Date());
        dataLab.account_add(acc1);
        WAccount acc2 = new WAccount();
        acc2.setIdPicture(R.drawable.pict_account_1);
        acc2.setSumma(100000);
        acc2.setCurrency(dataLab.fingCurrencyById(1,DataLab.get(context).getWCurrencyList()));
        acc2.setName("Кошелек 2");
        acc2.setDescribe("Бановская карта");
        acc2.setDateCreation(new Date());
        dataLab.account_add(acc2);

        WCategory category1 = new WCategory();
        category1.setName("Category 1");
        category1.setDescribe("Desc category 1");
        dataLab.category_add(category1);
        WCategory category2 = new WCategory();
        category2.setName("Category 2");
        category2.setDescribe("Desc category 2");
        category2.setCredit(true);
        dataLab.category_add(category2);
        WCategory category3 = new WCategory();
        category3.setName("Category 3");
        category3.setDescribe("Desc category 3");
        dataLab.category_add(category3);
*/
    }

}
