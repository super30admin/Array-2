/**
 * Time Complexity : O(n) where n = size of array nums 
 * Space Complexity : O(1)
 */

import java.util.ArrayList;
import java.util.List;

public class FindDisappeared {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String args[]){
        FindDisappeared obj = new FindDisappeared();
        int[] myArr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> result = obj.findDisappearedNumbers(myArr);
        System.out.println(result);
    }
}