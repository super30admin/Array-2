import java.util.*;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// - To have constant or reduce the space by having different data structures we just negate the values present in the array based on their index
// - if any number is still greater than zero after the above operation, that means that index number is not found in the array
public class FindNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // negate the numbers based on their index
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }
        // if number is still >0, the that particular index number is not found
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args){
        int[] nums= {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums)); //output:[5,6]
    }
}
