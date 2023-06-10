package org.aditya.model.split;

import org.aditya.model.User;

public abstract class Split {
    User paidBy;
    User paidTo;

    double amount;

    public Split(User paidBy, User paidTo, double amount) {
        this.paidBy = paidBy;
        this.paidTo = paidTo;
        this.amount = amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public User getPaidTo() {
        return paidTo;
    }

    public void setPaidTo(User paidTo) {
        this.paidTo = paidTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
