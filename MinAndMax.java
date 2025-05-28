// Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
import java.util.*;
public class MinAndMax {
    static List<Integer> findMinAndMax(int[] nums) {
        int len = nums.length;
        List<Integer> sol = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if(len % 2 == 0) {
            for(int i = 0; i < len; i += 2) {
                if(nums[i] < nums[i+1]) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i+1]);
                } else {
                    min = Math.min(min, nums[i+1]);
                    max = Math.max(max, nums[i]);
                }
            }
        } else {
            for(int i = 0; i < len - 1; i += 2) {
                if(nums[i] < nums[i+1]) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i+1]);
                } else {
                    min = Math.min(min, nums[i+1]);
                    max = Math.max(max, nums[i]);
                }
            }
            min = Math.min(min, nums[len - 1]);
            max = Math.max(max, nums[len - 1]);
        }
        sol.add(min);
        sol.add(max);
        return sol;
    }

    public static void main(String[] args) {
        int[] nums= {4,3,2,7,8,2,3,1};
        System.out.println("Min and Max in an array: " + findMinAndMax(nums));
    }
}
