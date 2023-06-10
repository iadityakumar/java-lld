package org.aditya.model.expense;

import org.aditya.model.ExpenseMetaData;
import org.aditya.model.ExpenseType;
import org.aditya.model.split.PercentSplit;
import org.aditya.model.User;
import org.aditya.model.split.Split;

public class PercentExpense extends Expense {


    public PercentExpense( User paidBy, ExpenseMetaData metaData, double amount, PercentSplit[] splits) {
        super( paidBy, metaData, amount, ExpenseType.PERCENT, splits);
    }

    @Override
    public boolean  validate() {
        int totalSplitPercent = 0;
        for (Split split : getSplits()) {
//            need to manually typecast split to PercentSplit
            PercentSplit percentSplit = (PercentSplit) split;
            totalSplitPercent += percentSplit.getPercent();
        }
        return totalSplitPercent == 100;
    }







}
