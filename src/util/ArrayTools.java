package util;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ArrayTools {
    static BiConsumer<int[], Consumer> foreach = (x, action) -> {
        for (int i = 0; i < x.length; i++) {
            action.accept(x[i]);
        }
    };

    static BiConsumer<int[], Consumer> reverseForeach = (x, action) -> {
        for (int i = x.length - 1; i >= 0; i--) {
            action.accept(x[i]);
        }
    };

    static void foreachInRange(int[] x, int start, int end, Consumer action) {
        for (int i = start; i < end; i++) {
            action.accept(x[i]);
        }
    }

    static void reverseForeachInRange(int[] x, int end, int start, Consumer action) {
        for (int i = end; i >= start; i--) {
            action.accept(x[i]);
        }
    }


//    public static void main(String[] args) {
//        int a[] = new int[]{1, 2, 3, 4, 5, 6};
////        foreach.accept(a,x-> System.out.println(x));
//
////        foreachInRange(a, 1, 3, x -> System.out.println(x));
//
//        reverseForeachInRange(a, 3, 1,
//                x -> {
//                    System.out.println(x);
//                }
//        );
//    }
}
