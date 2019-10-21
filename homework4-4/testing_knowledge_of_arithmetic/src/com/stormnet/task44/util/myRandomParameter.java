package com.stormnet.task44.util;


public class myRandomParameter {

    public static int getNumberFromOneToFour() {
        return (int) (Math.random() * 100 + 1);
    }

    public static int getAnyLargeNumber() {
        return (int) (Math.random() * 100 + 1);
    }

    public static String getRandomMathOperation() {
        switch (getNumberFromOneToFour()){
            case 1: return "addition";
            case 2: return "subtraction";
            case 3: return "multiplication";
            case 4: return "division";
        }
        return "exception";
    }

    public static String getMathOperationSymbol(String mathOperation) {
        switch (mathOperation){
            case "addition": return " + ";
            case "subtraction": return " - ";
            case "multiplication": return " * ";
            case "division": return " / ";
        }
        return "exception";
    }
}
