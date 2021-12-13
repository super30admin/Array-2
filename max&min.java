// Question: Given an array of numbers of length N, find both the minimum and maximum. Follow up : Can you do it using less than 2 * (N - 2) comparison
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> minmax(int[] nums) {
        if (nums == null || nums.length==0) return new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            else if (nums[i] < min) {
                min = nums[i];
            }
        }
        result.add(min);
        result.add(max);
        return result;
    }
}

// Time Complexity : O(n)
// Space Complexity : O(1)
// Here we take a pair of numbers and check the greater of the two with the max variable and smaller with the min variable
import java.util.*;

public class HelloWorld{

    public static void main(String []args){
        int[] nums = new int[]{3,2,7,1};
        List<Integer> result = new ArrayList<Integer>();
        result = HelloWorld.minmax(nums);
        System.out.println(result.get(0) + " " + result.get(1));
    }

    public static List<Integer> minmax(int[] nums) {
        if (nums == null || nums.length==0) return new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        int n= nums.length, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i=0; i<n-1; i=i+2) {
            if (nums[i] < nums[i+1]) {
                min = Math.min(min, nums[i]);
                max = Math.max(max, nums[i+1]);
            }
            else {
                min = Math.min(min, nums[i+1]);
                max = Math.max(max, nums[i]);
            }
        }
        if (n%2==1) { // odd number of elements in the nums array
            min = Math.min(min, nums[n-1]);
            max = Math.max(max, nums[n-1]);
        }
        result.add(min);
        result.add(max);

        return result;
    }
}