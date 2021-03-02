// In order to minimize the number of comparisions that are made to determine the minimum and maximum value in an array, we compare them in pairs

// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinComparisons {

    public static class Pair {
        private int min;
        private int max;

        public Pair() {
        };

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private static Pair getMinMax(int[] nums) {
        if (nums == null || nums.length == 0)
            return new Pair(-1, -1);
        int n = nums.length;
        Pair pair = new Pair();

        int index = 0;

        if (n % 2 == 0) {
            pair.min = nums[0] > nums[1] ? nums[1] : nums[0];
            pair.max = nums[0] > nums[1] ? nums[0] : nums[1];
            index = 2;
        } else {
            pair.min = nums[0];
            pair.max = nums[0];
            index = 1;
        }

        while (index < n - 1) {
            if (nums[index] > nums[index + 1]) {
                pair.max = pair.max < nums[index] ? nums[index] : pair.max;
                pair.min = pair.min > nums[index + 1] ? nums[index + 1] : pair.min;
            } else {
                pair.max = pair.max < nums[index + 1] ? nums[index + 1] : pair.max;
                pair.min = pair.min > nums[index] ? nums[index] : pair.min;
            }
            index += 2;
        }
        return pair;
    }

    public static void main(String[] args) {
        List<int[]> input = new ArrayList<>();
        Collections.addAll(input, new int[] { 4, 1, 2, 8, 9, 6, 11 }, new int[] { 99, 100, 66, 33, 12, 1000 },
                new int[] {});

        for (int[] nums : input) {
            Pair pair = getMinMax(nums);
            System.out.println("Min : " + pair.min + " Max : " + pair.max);
        }
    }
}
