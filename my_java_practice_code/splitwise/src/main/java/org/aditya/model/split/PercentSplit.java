package org.aditya.model.split;

import org.aditya.model.User;

public class PercentSplit extends Split {
    double percent;

    public PercentSplit(User paidBy, User paidTo, double amount, double percent ) {
        super(paidBy, paidTo, amount);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
