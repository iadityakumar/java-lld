package org.aditya.model.split;

import org.aditya.model.User;

public class ExactSplit extends Split {
    double amount;

    public ExactSplit(User paidBy, User paidTo, double amount ) {
        super(paidBy, paidTo , amount);
    }

}
