public class Conversion {
    public static int[] convertFromStringToInt(String[] fromArray, boolean isRoman) throws Exception {

        int[] toArray = new int[fromArray.length];

        try {
            if (isRoman) {
                for (int i = 0; i < fromArray.length; i++) toArray[i] = Roman.convertToArab(fromArray[i]);
            }
            if (!isRoman) {
                for (int i = 0; i < fromArray.length; i++) {
                    toArray[i] = Integer.parseInt(fromArray[i]);
                }
            }

        } catch (Exception e) {
            throw new Exception("Введенные данные не соответсвуют условию, оба числа должны быть в одном формате");
        }
        return toArray;
    }

    public static String convertFromIntToString(int result, boolean isRoman) throws Exception {
        if (!isRoman) return String.valueOf(result);
        else if (!Validation.isValidInterval(result, 1))
            throw new Exception("Результат не имеет соответсвия в римском исчислении, должен быть больше 0");
        else return Roman.reverseToRoman(result);
    }
}