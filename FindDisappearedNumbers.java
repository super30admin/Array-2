import java.util.*;
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    /*

    TC:O(n) where n is the length of nums
    SC:O(1)

    */
        if(nums==null || nums.length==0) return new ArrayList<>();

        int n=nums.length;
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[Math.abs(nums[i])-1]>0){
                nums[Math.abs(nums[i])-1]=nums[Math.abs(nums[i])-1]*-1;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
