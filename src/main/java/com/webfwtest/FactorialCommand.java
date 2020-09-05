package com.webfwtest;

import com.webfw.commands.PlainTextCommand;

import java.math.BigInteger;

public class FactorialCommand extends PlainTextCommand {

    @Override
    protected String getPlainText() {
        try {
            int number = Integer.parseInt(getParameters().get("n"));
            return getFactorial(number);
        } catch (NumberFormatException e) {
            return "Not a valid number defined";
        }
    }

    private String getFactorial(int number) {
        BigInteger factorial = new BigInteger("1");
        if (number < 0) {
            return "Number should be non-negative!";
        }
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return "Factorial of " + number + " is = " + factorial;
    }

}
