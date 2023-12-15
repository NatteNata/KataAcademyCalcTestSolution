public class Validation {
    public static <T> void isValidLength(T[] array, int num) throws Exception {
        if (array.length != num) throw new Exception("Введенные данные не соответсвуют условию");
    }

//    public static void isValidLength(String string, int num) throws Exception {
//        if (string.length() != num) throw new Exception("Введенные данные не соответсвуют условию");
//    }
//
//    public static <E> void isValidLength(List<E> list, int num) throws Exception {
//        if (list.size() != num) throw new Exception("Введенные данные не соответсвуют условию");
//    }

    public static void isValidInterval(int number, int min, int max) throws Exception {
        if (number < min || number > max)
            throw new Exception("Введенные данные не соответсвуют условию, числа должны быть целыми, от 1 до 10");
    }

    public static boolean isValidInterval(int number, int min) throws Exception {
        if (number < min)
            throw new Exception("Результат невозможно представить римскими числами, число меньше 1");
        else return true;
    }
}
