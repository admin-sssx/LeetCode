package util;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class TestString {
    void testString() {
        String s = new String();
    }


    public static boolean isPalindromes(String source) {
        Predicate<Integer> isOddNumber = number-> (number%2) == 1;
        int sourceLength = source.length();
        int left;
        int right;
        if(isOddNumber.test(sourceLength)) {
            left = sourceLength/2;
            right = sourceLength/2;
        } else {
            left = sourceLength/2 - 1;
            right = sourceLength/2;
        }
        for (int i = 0; i < (sourceLength/2)+(sourceLength%2); i++) {
            if(source.charAt(left) != source.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
    public static String nearestPalindromic(String n) {
        long original = Long.valueOf(n) ;
        long reduce = original - 1;
        long add = original + 1;
        while(true) {
            if(isPalindromes(String.valueOf(reduce))) {
                return String.valueOf(reduce);
            } else if(isPalindromes(String.valueOf(add))) {
                return String.valueOf(add);
            } else {
                reduce--;
                add++;
            }
        }
    }

    static AtomicBoolean firstCompleted = new AtomicBoolean(Boolean.FALSE);
    static AtomicBoolean secondCompleted = new AtomicBoolean(Boolean.FALSE);
    public static void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        Thread t = new Thread(printFirst,"printFirst");
        t.start();
//        printFirst.run();
    }

    public static void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
        while(!firstCompleted.get()) {

        }
        Thread t = new Thread(printSecond,"printSecond");
        t.start();
    }

    public static void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
        while(!secondCompleted.get()) {

        }
        Thread t = new Thread(printThird,"printThird");
        t.start();
    }

    public static void runs(int [] a) throws InterruptedException {
        for (int i = 0; i < a.length; i++) {
            if(a[i]== 1) {
                first(()->{
                    firstCompleted.set(Boolean.TRUE);
                    System.out.println("first");
                });
            }
            if(a[i]== 2) {
                second(()->{
                    secondCompleted.set(Boolean.TRUE);
                    System.out.println("second");
                });
            }
            if(a[i]== 3) {
                third(()->{
                    System.out.println("third");
                });
            }
        }
//        System.out.println("runs");
    }
    public static void main(String[] args) throws InterruptedException {
//        Boolean is = isPalindromes("1457541");
//        System.out.println(is);
//
//        System.out.println(nearestPalindromic("123"));
//        String s = "1s";
//        String s2 = s;
//        s2 = "ac";
//        System.out.println("s="+s+",s2="+s2);

        String s3 = "807045053224792883";
        int a[] = {1,2,3};
        runs(a);
    }

}
