import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class FizzBuzz {

    /**
     Given an integer n, return a string array answer (1-indexed) where:

     answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
     answer[i] == "Fizz" if i is divisible by 3.
     answer[i] == "Buzz" if i is divisible by 5.
     answer[i] == i (as a string) if none of the above conditions are true.
     */
    public static void main(String[] args) {
        System.out.println(printFizzBuzzV1(5));
        System.out.println(printFizzBuzzV2(5));

    }

    private static List<String> printFizzBuzzV1(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                res.add("FizzBuzz");
                continue;
            } else if (i % 3 == 0) {
                res.add("Fizz");
                continue;
            } else if (i % 5 == 0) {
                res.add("Buzz");
                continue;
            } else {
                res.add("" + i);
                continue;
            }
        }
        return res;
    }

    public static List<String> printFizzBuzzV2(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            switch (Boolean.hashCode(i % 5 == 0 && i % 3 == 0)) {
                case 1231:
                    res.add("FizzBuzz");
                    continue;
                case 1237:
                    switch (Boolean.hashCode(i % 3 == 0)) {
                        case 1231:
                            res.add("Fizz");
                            continue;
                        case 1237:
                            switch (Boolean.hashCode(i % 5 == 0)) {
                                case 1231:
                                    res.add("Buzz");
                                    continue;
                                case 1237:
                                    res.add(String.valueOf(i));
                                    continue;
                            }
                            continue;
                    }
                    continue;
            }
        }
        return res;
    }
}
