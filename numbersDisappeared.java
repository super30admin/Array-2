// Time Complexity : O(n)
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
import java.util.ArrayList;
import java.util.List;

public class numbersDisappeared{
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            int x = Math.abs(nums[i]);
            if(nums[x-1] > 0){
                nums[x-1] = nums[x-1] * -1;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                nums[i] = nums[i] * -1;
            }
            else{
                li.add(i+1);
            }
        }
        return li;
    }
}