package org.aditya.model.expense;

import org.aditya.model.ExpenseMetaData;
import org.aditya.model.ExpenseType;
import org.aditya.model.split.Split;
import org.aditya.model.User;

public abstract class Expense {

    User paidBy;


    double amount;
    ExpenseMetaData metaData;


    ExpenseType type;



    Split[] splits;


    public Expense( User paidBy, ExpenseMetaData metaData, double amount, ExpenseType type , Split[] splits) {
        this.paidBy = paidBy;
        this.metaData = metaData;
        this.amount = amount;
        this.type = type;

        this.splits = splits;

    }


    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }


    public ExpenseMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(ExpenseMetaData metaData) {
        this.metaData = metaData;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }


    public Split[] getSplits() {
        return splits;
    }

    public void setSplits(Split[] splits) {
        this.splits = splits;
    }





    public abstract boolean  validate();



}
