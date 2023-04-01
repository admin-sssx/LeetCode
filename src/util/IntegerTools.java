package util;

import java.util.function.Predicate;

public class IntegerTools {

    /**
     * 是否为奇数
     */
    public static Predicate<Integer> isOddNumber = number-> (number%2) == 1;

    /**
     * 是否为偶数
     */
    public static Predicate<Integer> isEvenNumber = number-> (number%2) == 0;
}
