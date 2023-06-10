package org.aditya.model.expense;

import org.aditya.model.ExpenseMetaData;
import org.aditya.model.ExpenseType;
import org.aditya.model.split.EqualSplit;
import org.aditya.model.split.Split;
import org.aditya.model.User;

public class EqualExpense extends Expense {

    public EqualExpense(User paidBy, ExpenseMetaData metaData, double amount, EqualSplit[] splits) {
        super(paidBy, metaData, amount, ExpenseType.EQUAL, splits);
    }

    @Override
    public boolean  validate() {
        return getAmount() != 0;
    }







}
