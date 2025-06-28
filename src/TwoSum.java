import java.util.*;
import java.util.concurrent.*;

class Solution {

    static class PairFinder implements Callable<int[]> {
        int[] nums;
        int start, end;
        int target;

        public PairFinder(int[] nums, int target, int start, int end) {
            this.nums = nums;
            this.target = target;
            this.start = start;
            this.end = end;
        }

        @Override
        public int[] call() {
            for (int i = start; i < end; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

    public int[] twoSum(int[] nums, int target) throws InterruptedException, ExecutionException {
        int n = nums.length;
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<int[]>> futures = new ArrayList<>();

        // Divide the index range among threads
        int chunkSize = n / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads - 1) ? n : start + chunkSize;
            futures.add(executor.submit(new PairFinder(nums, target, start, end)));
        }

        // Check results
        for (Future<int[]> future : futures) {
            int[] result = future.get();
            if (result != null) {
                executor.shutdownNow(); // Stop other threads
                return result;
            }
        }

        executor.shutdown();
        return new int[]{-1, -1};
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] nums = {2,5, 7, 11, 15};
        int target = 9;
        int[] result = sol.twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]
    }
}
