//TimeComplexity O(n)
//Space Complexity O(1)
import java.util.ArrayList;
import java.util.List;

class DisappearedNums {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
       for(int i =0; i<nums.length;i++){
           int newindex = Math.abs(nums[i])-1;
           
           if(nums[newindex]>0){
               nums[newindex] = - nums[newindex];
           }
       }
        List<Integer> res = new ArrayList<Integer>();
        for(int i =1; i <=nums.length;i++){
            if(nums[i-1] >0){
                res.add(i);
            }
        }
        return res;
    }
}