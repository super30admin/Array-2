// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


import java.util.ArrayList;
import java.util.List;

public class MissingNumber {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0 ; i < nums.length ; i++){
            int index = Math.abs(nums[i]);
            int value = nums[index - 1];
            if (value > 0)
                nums[index - 1] =  -value;
        }

        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i] > 0){
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args){
        int [] nums = { 4,3,2,7,8,2,3,1};
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.findDisappearedNumbers(nums));

    }
}