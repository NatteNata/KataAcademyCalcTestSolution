import java.util.Scanner;

public class Main {
    // калькулятор римских и арабских чисел до 10
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String inputExpression = scanner.nextLine();
        System.out.println(calc(inputExpression));
    }

    public static String calc(String input) throws Exception {
        int a, b;
        boolean isRoman;
        int result;
        String finalResult = "";

        String[] inputOperands = input.split("[*/\\-+]");

        if (inputOperands.length != 2) {
            throw new Exception("Введенные данные не соответсвуют условию");
        }

        String operation = setOperator(input);

        if (operation == null) {
            throw new Exception("Введенные данные не соответсвуют условию: " +
                    "доступны только операции сложения (+), вычитания (-), деления (/) или умножения (*)\"");
        }

        if (Roman.isRoman(inputOperands[0]) && Roman.isRoman(inputOperands[1])) {
            a = Roman.convertToArab(inputOperands[0]);
            b = Roman.convertToArab(inputOperands[1]);
            isRoman = true;
        } else if (!Roman.isRoman(inputOperands[0]) && !Roman.isRoman(inputOperands[1])) {
            a = Integer.parseInt(inputOperands[0]);
            b = Integer.parseInt(inputOperands[1]);
            isRoman = false;
        } else throw new Exception("Введенные данные не соответсвуют условию, оба числа должны быть в одном формате");

        if ((a < 1 || a > 10) || (b < 1 || b > 10)) {
            throw new Exception("Введенные данные не соответсвуют условию, числа должны быть целыми, от 1 до 10");
        }
        result = compute(a, b, operation);
        if (!isRoman) {
            finalResult += result;
        } else {
            if (result < 1) {
                throw new Exception("Результат не имеет соответсвия в римском исчислении, должен быть больше 0");
            } else {
                finalResult = Roman.reverseToRoman(result);
            }
        }
        return finalResult;
    }

    private static String setOperator(String inputExpression) {
        if (inputExpression.contains("+")) return "+";
        else if (inputExpression.contains("-")) return "-";
        else if (inputExpression.contains("/")) return "/";
        else if (inputExpression.contains("*")) return "*";
        else return null;
    }

    private static int compute(int a, int b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }

    static class Roman {
        static String[] romanArray = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        private static boolean isRoman(String input) {
            boolean isRoman = false;
            for (int i = 1; i < romanArray.length; i++) {
                if (input.equals(romanArray[i])) {
                    isRoman = true;
                    break;
                }
            }
            return isRoman;
        }

        private static int convertToArab(String roman) {

            for (int i = 1; i < 11; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }

        private static String reverseToRoman(int arab) {
            String resultRoman = "";
            for (int i = 1; i < romanArray.length; i++) {
                if (i == arab) {
                    resultRoman = romanArray[i];
                }
            }
            return resultRoman;
        }
    }
}