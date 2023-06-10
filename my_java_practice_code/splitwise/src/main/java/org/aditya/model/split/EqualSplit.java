package org.aditya.model.split;

import org.aditya.model.User;

public class EqualSplit extends Split {

    public EqualSplit(User paidBy, User paidTo , double amount) {
        super(paidBy, paidTo, amount);
    }

}
