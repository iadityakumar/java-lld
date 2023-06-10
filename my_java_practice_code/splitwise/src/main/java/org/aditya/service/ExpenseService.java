package org.aditya.service;

import org.aditya.model.ExpenseMetaData;
import org.aditya.model.ExpenseType;
import org.aditya.model.User;
import org.aditya.model.expense.EqualExpense;
import org.aditya.model.expense.ExactExpense;
import org.aditya.model.expense.Expense;
import org.aditya.model.expense.PercentExpense;
import org.aditya.model.split.EqualSplit;
import org.aditya.model.split.ExactSplit;
import org.aditya.model.split.PercentSplit;
import org.aditya.model.split.Split;

public class ExpenseService {


    public static Expense createExpense(ExpenseType expenseType ,User paidBy, ExpenseMetaData metaData, double amount, ExpenseType type , Split[] splits) {
        Expense expense;
        switch(expenseType) {
            case EQUAL:
                int noOfSplits = splits.length;
                for (Split split : splits) {
                    split.setAmount(amount/noOfSplits);
                }
                expense = new EqualExpense(paidBy, metaData, amount, (EqualSplit[]) splits);

            case EXACT:
                expense = new ExactExpense(paidBy, metaData, amount, (ExactSplit[]) splits);

            case PERCENT:
                for (Split split : splits) {
                    PercentSplit percentSplit = (PercentSplit) split;

                    split.setAmount((amount * percentSplit.getPercent())/100);
                }
                expense = new PercentExpense(paidBy, metaData, amount, (PercentSplit[]) splits);

                return expense;

            default:
                return null;
        }

    }
}
