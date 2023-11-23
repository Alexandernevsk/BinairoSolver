package org.example;

public class BinairoSolver {
    public String solve(String s) {

        if (s == null) {
            return "";
        }

        checkInvalidInput(s);

            s = applyRules(s);
            s = maxNumber(s);

        return s;
    }

    private static String applyRules(String s) {
        return s.replace("1.1", "101")
                .replace("0.0", "010")
                .replace("11.", "110")
                .replace(".11", "011")
                .replace(".00", "100")
                .replace("00.", "001");
    }

    private static String maxNumber(String s) {
        int amountOfOne = 0;
        int amountOfZero = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                amountOfZero++;
            } else if (s.charAt(i) == '1') {
                amountOfOne++;
            }
        }

        if (amountOfOne == (s.length() / 2)) {
            return s.replace('.', '0');
        } else if (amountOfZero == (s.length() / 2)) {
            return s.replace('.', '1');
        }

        return s;
    }

    private static void checkInvalidInput(String s) {
        if (s.length() % 2 != 0) {
            throw new IllegalArgumentException("length is unequal");
        }

        if (!s.matches("[10.]+")) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
