package com.leratoletsepe;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principalAmount = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;

        System.out.println("*****Mortgage Calculator*****");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Loan Amount (Principal R1K - R1M): ");
            principalAmount = scanner.nextInt();
            if (principalAmount >= 1000 && principalAmount <= 1_000_000)
                break;
            System.out.println("Enter an amount between R1000 and R1000000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = scanner.nextFloat();

            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter an interest rate between 1 and 30");
        }

        while (true){
            System.out.print("Period (years): ");
            byte years = scanner.nextByte();

            if(years >= 1 && years <= 30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter number of years between 1 and 30");
        }


        System.out.println("Your monthly repayment is: " + calculateMortgage(principalAmount, monthlyInterestRate, numberOfPayments));
    }
    
    public static String calculateMortgage(int principalAmount, float monthlyInterestRate, int numberOfPayments){
        float monthlyRepayments = (float) (principalAmount *
                ( (monthlyInterestRate * ( 1 + Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
                        (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1) ));

        String monthlyRepaymentsFormatted = NumberFormat.getCurrencyInstance().format(monthlyRepayments);
        return monthlyRepaymentsFormatted;
    }

}
