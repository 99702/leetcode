import java.util.ArrayList;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class ReverseInteger {
    public static void main(String[] args) {
        Util.print("reverseV1", () -> reverseV1(123));
        Util.print("reverseV2", () -> reverseV2(123)); // efficient
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


    private static int reverseV2(int x) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int reversed = 0;
        while(x != 0){
            int lastDigit = x % 10;
            int i1 = max / 10;
            if(reversed > i1 || (reversed == i1 && lastDigit > max%10)){
                return 0;
            }
            int i2 = min / 10;
            if(reversed < i2 || (reversed == i2 && lastDigit < min%10)){
                return 0;
            }

            reversed = reversed * 10 + lastDigit;
            x = x/ 10;
        }
        return reversed;
    }
}
