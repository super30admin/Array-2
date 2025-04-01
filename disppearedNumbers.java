// check for the offset approach if there is a combination of +ves and -ves
// if negative values are present or go for set but it requirs  

// TC: O(n)
// SC : O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0; i<n;i++){
            int num = nums[i];
            int idx= Math.abs(nums[i])-1;

            if(nums[idx]>0){
                nums[idx]*=-1;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }else{
                nums[i] *=-1;
            }
        }
        return result;
    }
}