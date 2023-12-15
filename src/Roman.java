public class Roman {

    //region ROMAN_NUMERALS
    private static final String[] ROMAN_NUMERALS = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

    //endregion
//    static boolean isRoman(String input) {
//        boolean isRoman = false;
//        for (int i = 1; i < ROMAN_NUMERALS.length; i++) {
//            if (input.equals(ROMAN_NUMERALS[i])) {
//                isRoman = true;
//                break;
//            }
//        }
//        return isRoman;
//    }

//    static boolean isRoman(String[] inputArray) {
//        boolean isRoman = false;
//        for (int i = 1; i < ROMAN_NUMERALS.length; i++) {
//            if (inputArray.equals(ROMAN_NUMERALS[i])) {
//                isRoman = true;
//                break;
//            }
//        }
//        return isRoman;
//    }

    static boolean isRomanElements(String[] fromArray) {
        boolean isRoman = false;
        for (String s : fromArray) {
            for (int j = 1; j < 11; j++) {
                if (s.equals(ROMAN_NUMERALS[j])) {
                    isRoman = true;
                    break;
                }
            }
            return isRoman;
        }
        return isRoman;
    }

    static int convertToArab(String roman) {
        for (int i = 1; i < 11; i++) if (roman.equals(ROMAN_NUMERALS[i])) return i;
        return -1;
    }

    static String reverseToRoman(int arab) {
        for (int i = 1; i < ROMAN_NUMERALS.length; i++) if (arab == i) return ROMAN_NUMERALS[i];
        return "Ошибка, которой не должно быть, на основании условий задачи";
    }
}
