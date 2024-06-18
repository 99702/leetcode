import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Util.print("reverseV1", () -> reverseV1(-2147483648));
        Util.print("reverseV1", () -> reverseV1(-123));
        Util.print("reverseV1", () -> reverseV1(213));
    }

    public static int reverseV1(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int sig = Math.round(Math.signum(x));
        int temp = sig* x;
        if(x < 0 && temp == x) return 0;
        x = temp;
        ArrayList<String> list = new ArrayList<>();
        for (String s : String.valueOf(x).split("")){
            list.add(0, s);
        }
            long res = sig * Long.parseLong(String.join("", list));
            if(res < min || res > max){
                return 0;
            }
            return Math.toIntExact(res);
    }
}
