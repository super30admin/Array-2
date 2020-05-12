
//Time Complexity : O(n) (n = length of the input)
//Space Complexity : O(1)
//Run successfully on leetcode
//Problem: No problem

//Here we are going to negate the indexes which are present in the current array
//The indexes which will be missed, those indexes will be the missing number


import java.util.ArrayList;
import java.util.List;

public class Array_2_Problem_1 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null || nums.length == 0) return new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i ++)
        {
            int indexNegate = Math.abs(nums[i]) - 1;
            nums[indexNegate] = -1 * Math.abs(nums[indexNegate]);
        }
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i]>0)
            {
                arr.add(i+1);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int nums[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
