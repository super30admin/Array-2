import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i])-1;
            //marking negative values in list 
            if(nums[idx]>0){
                nums[idx]=nums[idx]*-1;
            }
        }   
        for(int i=0;i<n;i++){
            //for positive value add the the next corresponding index number in list
            if(nums[i]>0){
                li.add(i+1);
            }
            //marking negative values back to positive
            else{
                nums[i]=nums[i]*-1;
            }

        }  
        return li;
    }
}