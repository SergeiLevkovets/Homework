package com.stormnet.task44.service;

import com.stormnet.task44.util.MyRandomParameter;

public class Service {

    public static Integer getMathAnswer(int first, int second, String mathOperation) {
        int answer = 0;
        switch (mathOperation) {
            case "addition":
                return first + second;
            case "subtraction":
                return first - second;
            case "multiplication":
                return first * second;
            case "division":
                return first % second;
        }
        return 0;
    }

    public static int[] getResultArr(int answer) {
        int[] result = new int[4];
        result[0] = getMathAnswer(MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getRandomMathOperation());
        result[1] = getMathAnswer(MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getRandomMathOperation());
        result[2] = getMathAnswer(MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getRandomMathOperation());
        result[3] = getMathAnswer(MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getAnyLargeNumber(), MyRandomParameter.getRandomMathOperation());
        result[MyRandomParameter.getNumberFromOneToFour() - 1] = answer;
        return result;
    }


}
