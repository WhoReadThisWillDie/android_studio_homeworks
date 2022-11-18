package com.example.homework_9;

import android.app.VoiceInteractor;

public class Problem {
    private int result;

    public int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public int getResult() {
        return result;
    }

    public int getNoiseResult() {
        return result + getRandom(-10, 10);
    }

    public String getProblem() {
        int a = getRandom(-100, 100);
        int b = getRandom(0, 100);
        char sign = getRandomSign();
        switch (sign) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        return a + " " + sign + " " + b;
    }

    private char getRandomSign() {
        switch (getRandom(1, 5)) {
            case 1:
                return '+';
            case 2:
                return '-';
            case 3:
                return '*';
            case 4:
                return '/';
        }
        return 0;
    }
}
