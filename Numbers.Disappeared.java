//The approach here is to change the temporary state of the number at an index to note that the number is present in the array.
//Time Complexity: O(n)
//Space Complexity: O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<Integer>();
        for(int i = 0; i<nums.length; i++){
            int var = Math.abs(nums[i]);
            if(nums[var-1]>0)
            nums[var-1] = -1*nums[var-1];
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]<0){
                nums[i] = -1*nums[i];
            } else{
                missing.add(i+1);
            }
        }
        return missing;
    }
}