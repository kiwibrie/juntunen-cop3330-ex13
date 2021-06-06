package base;

/*
 *  UCF COP3330 Summer 2021 Assignment 13 Solution
 *  Copyright 2021 Brianne Juntunen
 */
import java.util.Scanner;

import static java.lang.Math.pow;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        App myApp = new App();

        double principal = myApp.prompt("principal amount");
        double rate = myApp.prompt("rate");
        double years = myApp.prompt("number of years");
        double compounds = myApp.prompt("number of times the interest is compounded per year");

        double interest = myApp.calculateInterest(principal, rate, years, compounds);

        myApp.printOutput(principal, rate, years, compounds, interest);
    }

    public void printOutput(double prin, double rate, double years, double comp, double interest){
        System.out.printf("$%.2f invested at %.1f%% for %d years compounded %d times " +
                "per year is $%.2f.", prin, rate, (int) years, (int) comp, interest);
    }

    public double calculateInterest(double prin, double rate, double years, double comp){
        double convertedRate = rate/100;
        return prin * pow(1 + (convertedRate/comp), comp*years);
    }

    public double prompt(String prompt){
        System.out.printf("What is the %s? ", prompt);
        return in.nextDouble();
    }
}
