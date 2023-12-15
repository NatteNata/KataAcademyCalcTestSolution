import java.util.Scanner;

// калькулятор римских и арабских чисел до 10
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
        scanner.close();
    }

    public static String calc(String input) throws Exception {

        String[] inputOperands = splitStringRegex(input);

        Validation.isValidLength(inputOperands, 2);

        boolean isRoman = Roman.isRomanElements(inputOperands);

        int[] inputConvert = Conversion.convertFromStringToInt(inputOperands, isRoman);

        for (int i : inputConvert) Validation.isValidInterval(i, 1, 10);

        int result = calculate(inputConvert[0], inputConvert[1], input);

        return Conversion.convertFromIntToString(result, isRoman);
    }

    public static String[] splitStringRegex(String input) throws Exception {
        return input.split("[*/\\-+]");
    }

    public static int calculate(int a, int b, String input) throws Exception {
        if (input.contains("+")) return Calculation.add(a, b);
        else if (input.contains("-")) return Calculation.substract(a, b);
        else if (input.contains("/")) return Calculation.divide(a, b);
        else if (input.contains("*")) return Calculation.multiply(a, b);
        else throw new Exception("Ошибка которой не должно быть");
    }
}