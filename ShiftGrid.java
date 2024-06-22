import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class ShiftGrid {
    public static void main(String[] args) {
        int[][] listList = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        var key = 2;

        Util.print("shiftGridV1", () -> shiftGridV1(listList, key));
    }

    public static List<List<Integer>> shiftGridV1(int[][] grid, int k) {
        List<Integer> flatten = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        flatten(grid, flatten);
        shiftElementBasedOnKey(k, flatten, rows, cols);
        return convert1dTo2d(flatten, rows, cols);
    }

    private static List<List<Integer>> convert1dTo2d(List<Integer> flatten, int rows, int cols) {
        List<List<Integer>> final2D = new ArrayList<>();
        for (var i = 0; i < rows; i++) {
            var startIndex = i * cols;
            var endIndex = startIndex + cols;
            List<Integer> integerList = flatten.subList(startIndex, endIndex);
            final2D.add(integerList);
        }
        System.out.println(final2D);
        return final2D;
    }

    private static void shiftElementBasedOnKey(int key, List<Integer> flatten, int rows, int cols) {
        for (var j = 0; j < key; j++) {
            var lastElement = flatten.get(rows * cols - 1);
            for (int i = rows * cols - 1; i > 0; i--) {
                flatten.set(i, flatten.get(i - 1));
            }
            flatten.set(0, lastElement);
        }
    }

    private static void flatten(int[][] listList, List<Integer> flatten) {
        for (int i = 0; i <= listList.length - 1; i++) {
            int[] integers = listList[i];
            for (int j = 0; j <= integers.length - 1; j++) {
                flatten.add(integers[j]);
            }
        }
    }

}
