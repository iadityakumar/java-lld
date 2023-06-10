package org.aditya.model.expense;

import org.aditya.model.ExpenseMetaData;
import org.aditya.model.ExpenseType;
import org.aditya.model.User;
import org.aditya.model.split.ExactSplit;
import org.aditya.model.split.Split;

public class ExactExpense extends Expense {


    public ExactExpense(User paidBy, ExpenseMetaData metaData, double amount, ExactSplit[] splits) {
        super(paidBy, metaData, amount, ExpenseType.EXACT , splits);
    }

    @Override
    public boolean  validate() {
        double totalSplitAmount = 0;
        for (Split split : getSplits()) {
            ExactSplit exactSplit = (ExactSplit) split;
            totalSplitAmount += exactSplit.getAmount();
        }
        return totalSplitAmount == this.amount;
    }







}
