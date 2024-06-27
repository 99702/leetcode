import java.util.*;

/**
 * @author Rajan Paudel <rajan99702@proton.me>
 */
public class SubarraySumDivisibleByK {
    public static void main(String[] args) {

        Util.print("singleNumberV2", () -> subarraysDivByK(
                new int[]{4,5,0,-2,-3,1}, 5));
    }

    private static int subarraysDivByK(int[] nums, int k ) {
        List<List<Integer>> resultSet = new ArrayList<>();
        backTrack(resultSet,new ArrayList<>(), nums, 0);
        return 0;
    }

    private static void backTrack(List<List<Integer>> resultSet,List<Integer> tempSet ,int[] nums, int start) {
            resultSet.add(new ArrayList<>(tempSet));
            for(int i =start;i < nums.length;i++){
//                backTrack(resultSet, tempSet,nums, i+1);
//                tempSet.remove(tempSet.size() - 1);
            }
    }

}
