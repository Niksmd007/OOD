import java.util.HashMap;

public class TwoSumUnsorted {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cmp = target - nums[i];
            if (map.containsKey(cmp)) {
                return new int[]{i, map.get(cmp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // Return this if no solution is found
    }

    public static void main(String[] args) {
        TwoSumUnsorted solution = new TwoSumUnsorted();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);

        System.out.println("Indices of the numbers that add up to " + target + " are: "
                + result[0] + " and " + result[1]);
    }
}
