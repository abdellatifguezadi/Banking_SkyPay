package org.example.service.impl;

import org.example.entity.Transaction;
import org.example.service.AccountService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Account implements AccountService {
    private  int balance = 0;
    private  LocalDate currentDate = LocalDate.now();
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public void deposit(int amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
        Transaction transaction = new Transaction(currentDate, amount, balance);
        transactions.add(transaction);
    }

    @Override
    public void withdraw(int amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if(amount > balance){
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
        Transaction transaction = new Transaction(currentDate, -amount, balance);
        transactions.add(transaction);
    }

    @Override
    public void printStatement() {
        System.out.println("Date        || Amount  || Balance");
        ArrayList<Transaction> reversedTransactions = new ArrayList<>(transactions);
        Collections.reverse(reversedTransactions);
        for (Transaction transaction : reversedTransactions) {
            System.out.printf("%s || %d     || %d%n",
                    transaction.date().format(formatter),
                    transaction.amount(),
                    transaction.balance());
        }
    }
}
