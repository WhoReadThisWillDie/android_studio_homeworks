package com.example.homework_9;

import java.util.Random;

public class Finances {
    private String fullName;
    private int amount;
    private boolean sign;
    private String date;

    public Finances(String fullName, int amount, boolean sign, String date) {
        this.fullName = fullName;
        this.amount = amount;
        this.sign = sign;
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isSign() {
        return sign;
    }

    public String getDate() {
        return date;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private static final String[] names = {"Ivan", "Petr", "Pashka", "Ryan", "Shrek"};
    private static final String[] surnames = {"Ivanov", "Gosling", "Petrov", "Charming", "Jobs"};
    private static final Random random = new Random();

    public static Finances getRandom() {
        String fullName = names[random.nextInt(names.length)] + " " + surnames[random.nextInt(surnames.length)];
        int amount = random.nextInt(5_000) + 500;
        boolean sign = random.nextBoolean();
        String date = String.format("%2d", random.nextInt(30) + 1) + "." + String.format("%2d", random.nextInt(11) + 1) + ".2022";
        return new Finances(fullName, amount, sign, date);
    }
}
