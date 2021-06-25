package com.leratoletsepe;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.println("*****Mortgage Calculator*****");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Loan Amount (Principal): ");
        int principalAmount = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterestRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        float monthlyRepayments = (float) (principalAmount *
                ( (monthlyInterestRate * ( 1 + Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1) ));

       String monthlyRepaymentsFormatted = NumberFormat.getCurrencyInstance().format(monthlyRepayments);

        System.out.println("Your monthly repayment is: " + monthlyRepaymentsFormatted);
    }
}
