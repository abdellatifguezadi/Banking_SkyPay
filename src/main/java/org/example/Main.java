package org.example;

import org.example.service.impl.Account;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.setCurrentDate(LocalDate.of(2012, 1, 10));
        account.deposit(1000);

        account.setCurrentDate(LocalDate.of(2012, 1, 13));
        account.deposit(2000);

        account.setCurrentDate(LocalDate.of(2012, 1, 14));
        account.withdraw(500);

        account.printStatement();


        System.out.println("--- Testing Exception ---");
        try{
            account.deposit(-100);
        }catch (IllegalArgumentException e){
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        try{
            account.withdraw(10000);
        }catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}