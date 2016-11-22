package com.brainacademy.object;

public class Number {
    private int val;

    public Number(int val) {
        this.val = val;
    }

    public void print() {
        System.out.println(val);
    }

    public boolean isSymmetric() {
        int[] digits = getDigits();

        boolean res = true;
        int length = digits.length;

        for (int i = 0; i < length / 2; i++) {
            if (digits[i] != digits[length - i - 1]) {
                res = false;
                break;
            }
        }

        return res;
    }

    public int[] getDigits() {
        int totalDigits = (int) Math.ceil(Math.log10(val));
        int[] digits = new int[totalDigits];
        int tmpVal = val;

        int idx = totalDigits - 1;
        while (tmpVal > 0) {
            digits[idx] = tmpVal % 10;
            idx--;

            tmpVal = tmpVal / 10;
        }

        return digits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (! (o instanceof Number)) {
            return false;
        }

        Number number = (Number) o;
        return val == number.val;
    }


    public static Number add(Number n1, Number n2) {
        return new Number(n1.val + n2.val);
    }
}
