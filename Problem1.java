package Array2;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Since numbers are in range of 1 to N, we go to the currentNum-1 index and make the value there -ve.
 * This indicated that index+1 is present. Any index with +ve value will help us find missing no.
 * 
 * 
 * Time Complexity :
 * O(n) as we traverse array twice
 * 
 * Space Complexity :
 * O(1) as we are not using any auxillary DS
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int curNum=Math.abs(nums[i]);
            if(nums[curNum-1]>0){
                nums[curNum-1]=nums[curNum-1]*-1;
            }
        }

        List<Integer> output=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                output.add(i+1);
            }
            else
                nums[i]=nums[i]*-1;
        }

        return output;
    }
}
