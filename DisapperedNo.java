package Arrays1;

import java.util.ArrayList;
import java.util.List;

public class DisapperedNo {
	 public List<Integer> findDisappearedNumbers(int[] nums) {
         List<Integer> result= new ArrayList<Integer>();
       if(nums==null || nums.length==0) return result;
       //first pass
       for(int i=0;i<nums.length;i++){
           int idx=Math.abs(nums[i])-1;
           if(nums[idx]>0)  nums[idx]*=-1;
          
       }
       //second pass
       for(int i=0;i<nums.length;i++){
           if(nums[i]>0){
               result.add(i+1);
           }
          
       }
       return result;
   }

}
