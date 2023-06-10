package org.aditya.repository;

import org.aditya.model.ExpenseMetaData;
import org.aditya.model.ExpenseType;
import org.aditya.model.User;
import org.aditya.model.expense.Expense;
import org.aditya.model.split.Split;
import org.aditya.service.ExpenseService;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpenseRepository {

    HashMap<String, User> userHashMap = new HashMap<String, User>();
//    HashMap <String, Expense> expenses = new HashMap<String, Expense>();
    ArrayList<Expense> expenseList = new ArrayList<Expense>();
    HashMap <String, HashMap <String, Double>> balanceSheet = new HashMap<String, HashMap <String, Double>>();

    public ExpenseRepository () {

    }

    public void addUser (User user) {
        userHashMap.put(user.getId(), user);

    }

    public void removeUser (String username) {
//        TODO
    }

    public void addExpense (ExpenseType expenseType , User paidBy, ExpenseMetaData metaData, double amount, ExpenseType type , Split[] splits) {

        Expense expense = ExpenseService.createExpense(expenseType, paidBy,metaData,amount,type,splits);
        expenseList.add(expense);
//        balanceSheet.put(paidBy.getId(), )
        String paidById = paidBy.getId();
        for (Split split : splits) {
            String paidToId = split.getPaidTo().getId();
            HashMap <String, Double> userExpenses = balanceSheet.getOrDefault(paidById, new HashMap<>() {{
                put(paidToId, split.getAmount());
            }});
//            if (userExpenses == null) {
////                balanceSheet.put(paidById, new HashMap<String, Double>() {{
////                    put(paidToId, split.getAmount());
////                }});
//                userExpenses = new HashMap<>() {{
//                    put(paidToId, split.getAmount());
//                }};
//            }
            if (!userExpenses.containsKey(paidToId)) {
                userExpenses.put(paidToId, 0.0);
            }

            userExpenses.put(paidToId, userExpenses.get(paidToId) + split.getAmount());
            balanceSheet.put(paidById, userExpenses);

//            set -ve paid to side
//            TODO: refactor this code repeating

            userExpenses = balanceSheet.getOrDefault(paidToId, new HashMap<>() {{
                put(paidById, -split.getAmount());
            }});

            if (!userExpenses.containsKey(paidById)) {
                userExpenses.put(paidById, 0.0);
            }

            userExpenses.put(paidById, userExpenses.get(paidById) - split.getAmount());
            balanceSheet.put(paidToId, userExpenses);

        }

    }





}
