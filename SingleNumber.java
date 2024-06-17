import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumberV1(new int[]{4, 1, 2, 1, 2}));
        System.out.println(singleNumberV2(new int[]{-684,-672,210,275,852,-743,-273,-405,-53,-751,-564,316,-248,-124,-415,160,983,468,-987,-711,561,-676,-702,803,-797,-177,-584,-956,43,874,924,-783,-210,900,-787,-269,477,708,-107,197,-499,497,-481,382,-117,966,-145,959,405,326,-812,-225,-633,504,-935,646,-841,-498,-171,-234,-196,848,-27,228,-479,-717,690,78,692,-126,820,-266,981,41,-212,-876,628,-268,8,-788,-968,-770,-635,-606,-616,168,81,-66,-972,-934,-211,353,855,568,379,285,-400,941,-878,-315,281,928,-669,500,-631,-204,-800,-855,-728,-537,-203,221,896,-383,-120,-328,44,-815,826,-668,-775,-748,808,152,-48,-617,-3,-684,-672,210,275,852,-743,-273,-405,-53,-751,-564,316,-248,-124,-415,160,983,468,-987,-711,561,-676,-702,803,-797,-177,-584,-956,43,874,924,-783,-210,900,-787,-269,477,708,-107,197,-499,497,-481,382,-117,966,-145,959,405,326,-812,-225,-633,504,-935,646,-841,-498,-171,-234,-196,848,-27,228,-479,-717,690,78,692,-126,820,-266,981,41,-212,-876,628,-268,8,-788,-968,-770,-635,-606,-616,168,81,-66,-972,-934,-211,353,855,568,379,285,-400,941,-878,-315,281,928,-669,500,-631,-204,-800,-855,-728,-537,-203,221,896,-383,-120,-328,44,-815,826,-668,-775,-748,808,152,-48,-617,-3,416}));
        System.out.println(singleNumberV3(new int[]{1}));
    }

    public static int singleNumberV1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev_n = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            prev_n = prev_n ^ nums[i];
        }
        return prev_n;
    }

    public static int singleNumberV2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        AtomicInteger prev_n = new AtomicInteger(nums[0]);
        Arrays.stream(Arrays.copyOfRange(nums, 1, nums.length)).parallel().forEach(n -> {
            prev_n.set(prev_n.get() ^ n);
        });
        return prev_n.get();
    }

    public static int singleNumberV3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        ForkJoinPool customForkJoinPool = new ForkJoinPool(3);
        AtomicInteger prev_n = new AtomicInteger(nums[0]);
        try {
            customForkJoinPool.submit(() -> {
                for (int i = 1; i <= nums.length - 1; i++) {
                prev_n.set(prev_n.get() ^ nums[i]);
                }
            }).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return prev_n.get();
    }
}
